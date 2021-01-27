package com.beauty.jvm;

/**
 * 双亲委派 问题
 *
 * @author yufw
 * @version v0.1.0.0
 * @date 2021 /1/27 19:55
 * @since v0.1.0.0
 */
public class ClassLoaderTest extends ClassLoader {

    /**
     * Loads the class with the specified <a href="#binary-name">binary name</a>.
     * This method searches for classes in the same manner as the {@link
     * #loadClass(String, boolean)} method.  It is invoked by the Java virtual
     * machine to resolve class references.  Invoking this method is equivalent
     * to invoking {@link #loadClass(String, boolean) loadClass(name,
     * false)}.
     *
     * @param name The <a href="#binary-name">binary name</a> of the class
     *
     * @return The resulting {@code Class} object
     *
     * @throws ClassNotFoundException If the class was not found
     */
    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if (name.equals("java.lang.Integer")){

            return Class.forName(name);
        }

        return super.loadClass(name);
    }

    /**
     * Finds the class with the specified <a href="#binary-name">binary name</a>.
     * This method should be overridden by class loader implementations that
     * follow the delegation model for loading classes, and will be invoked by
     * the {@link #loadClass loadClass} method after checking the
     * parent class loader for the requested class.
     *
     * @param name The <a href="#binary-name">binary name</a> of the class
     *
     * @return The resulting {@code Class} object
     *
     * @throws ClassNotFoundException If the class could not be found
     * @implSpec The default implementation throws {@code ClassNotFoundException}.
     * @since 1.2
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }
}
