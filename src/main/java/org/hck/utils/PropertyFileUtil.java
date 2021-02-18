package org.hck.utils;

import org.hck.constants.FrameworkConstants;
import org.hck.enums.ConfigProperties;
import org.hck.exceptions.FrameworkException;
import org.hck.exceptions.InvalidPropertyFilePathException;
import org.hck.exceptions.PropertyFileUsageException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

/**
 * <p>
 * This class is responsible for reading the properties from properties file.
 *
 * <p>
 * It is also responsible for getting value for the key from the property file and storing in Map,
 * inorder to reduce the number of calls to properties file.
 *
 * @author Harshavardhan Kavuri
 * @version 1.0
 * @see ConfigProperties
 * @since 1.0
 */
public final class PropertyFileUtil {

    /**
     * Singleton classes-prevent class instances being created in any place other than this very class.
     */
    private PropertyFileUtil() {
    }

    private static final Map<String, String> CONFIG_MAP = new HashMap<>();
    private static Properties prop = new Properties();

    /*
     *  Loading properties from .properties file to Map. The property file is read only once when the class is loaded to memory.
     * @throws InvalidPropertyFilePathException Thrown if property file cannot be found in specified path.
     * @throws FrameworkException Thrown if some error occurred while reading the property file.
     *
     */
    static {
        try (FileInputStream file = new FileInputStream(FrameworkConstants.getPropertyFilePath())) {
            prop.load(file);
            prop.forEach((key, value) -> CONFIG_MAP.put(String.valueOf(key), String.valueOf(value).trim()));
        } catch (FileNotFoundException ex) {
            throw new InvalidPropertyFilePathException("Properties file you trying to read not found at the path specified.");
        } catch (IOException ex) {
            throw new FrameworkException("Some error occurred while reading excel file.");
        }

    }

    /**
     * Returns the property value from the Map for the key supplied.
     *
     * @param key Property key whose value need to retrieved.
     * @return String value of the key.
     * @throws PropertyFileUsageException thrown if the provided key is not in Map.
     *
     */
    public static String get(ConfigProperties key){
        if (Objects.isNull(key) || Objects.isNull(CONFIG_MAP.get(key.name().toLowerCase()))) {
            throw new PropertyFileUsageException("Property name '" + key + "' is not found. Please check config.properties file.");
        }
        return CONFIG_MAP.get(key.name().toLowerCase());
    }

    /**
     * Returns the property value from the .properties file for the key supplied.
     *
     * @param key Property key whose value need to retrieved.
     * @return String value of the key.
     * @throws IllegalArgumentException thrown if the provided key is not in .properties file.
     */
    public static String getProp(ConfigProperties key) {

        if (Objects.isNull(key) || Objects.isNull(prop.getProperty(key.name().toLowerCase()))) {
            throw new PropertyFileUsageException("Property name '" + key + "' is not found. Please check config.properties file.");
        }
        return prop.getProperty(key.name().toLowerCase()).trim();
    }







}
