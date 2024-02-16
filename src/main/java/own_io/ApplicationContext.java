package own_io;

import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfo;
import io.github.classgraph.ScanResult;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;


public class ApplicationContext {
    private final Map<Class<?>, Object> beans = new HashMap<>();

    public ApplicationContext(String packageName) {
        try (ScanResult scanResult = new ClassGraph().enableAllInfo().whitelistPackages(packageName).scan()) {
            for (ClassInfo classInfo : scanResult.getAllClasses()) {
                Class<?> clazz = classInfo.loadClass();
                if (clazz.isAnnotationPresent(Component.class)) {
                    registerBean(clazz);
                }
            }
        }
    }

    public <T> T getBean(Class<T> clazz) {
        return clazz.cast(beans.get(clazz));
    }

    private void registerBean(Class<?> clazz) {
        try {
            Constructor<?> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);
            Object beanInstance = constructor.newInstance();

            for (Field field : clazz.getDeclaredFields()) {
                if (field.isAnnotationPresent(Autowired.class)) {
                    field.setAccessible(true);
                    Class<?> fieldClass = field.getType();
                    Object fieldInstance = beans.get(fieldClass);
                    if (fieldInstance == null) {
                        fieldInstance = fieldClass.getDeclaredConstructor().newInstance();
                        beans.put(fieldClass, fieldInstance);
                    }
                    field.set(beanInstance, fieldInstance);
                }
            }

            beans.put(clazz, beanInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}