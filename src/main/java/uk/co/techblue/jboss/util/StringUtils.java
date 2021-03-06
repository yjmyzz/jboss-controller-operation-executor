/*******************************************************************************
 * Copyright 2013 Technology Blueprint Ltd
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package uk.co.techblue.jboss.util;

/**
 * The Utility class for String operations.
 * 
 * @author <a href="mailto:ajay.deshwal@techblue.co.uk">Ajay Deshwal</a>
 */
public class StringUtils {

    /** The Constant EMPTY. */
    private static final String EMPTY = "";

    /**
     * Returns an empty string if passed value is null.
     * 
     * @param value the String value
     * @return the default string
     */
    public static String defaultString(String value) {
        return value == null ? EMPTY : value;
    }

    /**
     * Checks if the passed character sequence value is null or blank.
     * 
     * @param cs the character sequence
     * @return true, if character sequence is null or blank
     */
    public static boolean isBlank(CharSequence cs) {
        int charLength;
        if (cs == null || (charLength = cs.length()) == 0) {
            return true;
        }
        for (int i = 0; i < charLength; i++) {
            if (Character.isWhitespace(cs.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if the passed character sequence value is not null and not blank.
     * 
     * @param cs the character sequence
     * @return true, if character sequence is not null and not blank
     */
    public static boolean isNotBlank(CharSequence cs) {
        return !isBlank(cs);
    }
}
