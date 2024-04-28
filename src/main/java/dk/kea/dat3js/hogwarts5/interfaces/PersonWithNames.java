package dk.kea.dat3js.hogwarts5.interfaces;

public interface PersonWithNames {
    String getFirstName();
    String getLastName();
    String getMiddleName();


    void setFirstName(String firstName);
    void setLastName(String lastName);

    void setMiddleName(String middleName);

    default String getFullName() {
        if (getFirstName() != null) {
            return getFirstName() + (getMiddleName() != null ? " " + getMiddleName() : "") + (getLastName() != null ? " " + getLastName() : "");
        }
        return null;
    }

    default void setFullName(String fullName) {
        if (fullName == null || fullName.isEmpty()) {
            setFirstName(null);
            setMiddleName(null);
            setLastName(null);
        } else if (fullName.trim().indexOf(' ') != fullName.trim().lastIndexOf(' ')) {
            // Find spaces
            int firstSpace = fullName.trim().indexOf(' ');
            int lastSpace = fullName.trim().lastIndexOf(' ');

            //Set names
            setFirstName( capitalize(fullName.substring(0, firstSpace).trim()));
            setMiddleName( capitalize(fullName.substring(firstSpace+1, lastSpace).trim()));
            setLastName( capitalize(fullName.substring(lastSpace+1).trim()));
        } else if (fullName.trim().indexOf(' ') > 1) {
            // Find space
            int space = fullName.trim().indexOf(' ');

            setFirstName(capitalize(fullName.substring(0, space)));
            setMiddleName(null);
            setLastName(capitalize(fullName.substring(space+1)));
        } else {
            setFirstName(capitalize(fullName));
            setMiddleName(null);
            setLastName(null);
        }
    }

    default String capitalize(String name) {

        // return if null
        if (name == null || name.isEmpty()) {
            return name;
        }

        // Check if name starts with "Mc"
        if (name.length() > 2 && name.substring(0, 2).equalsIgnoreCase("mc")) {
            return "Mc" + name.substring(2, 3).toUpperCase() + name.substring(3).toLowerCase();
        }

        // Capitalize each part separated by space or dash
        StringBuilder result = new StringBuilder();
        String[] parts = name.split("[\\s-]");
        for (int i = 0; i < parts.length; i++) {
            String part = parts[i];
            if (!part.isEmpty()) {
                if (i > 0 && part.length() > 2 && part.substring(0, 2).equalsIgnoreCase("mc")) {
                    // Handle "Mc" part in non-first parts
                    result.append("Mc").append(part.substring(2, 3).toUpperCase()).append(part.substring(3).toLowerCase());
                } else {
                    result.append(part.substring(0, 1).toUpperCase()).append(part.substring(1).toLowerCase());
                }
                // Add dash if it's not the last part and if the current part ends with a dash
                if (i < parts.length - 1 && name.charAt(name.indexOf(part) + part.length()) == '-') {
                    result.append("-");
                } else if (i < parts.length - 1) {
                    result.append(" ");
                }
            }
        }

        return result.toString().trim(); // Trim leading/trailing whitespace and return string.
    }







}
