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
        if (name.trim().contains(" ")) {
            int space = name.trim().indexOf(' ');
            return capitalize(name.substring(0, space)) + " " + capitalize(name.substring(space+1));
        } else if (!name.isEmpty()) {
            return name.trim().substring(0, 1).toUpperCase() + name.trim().substring(1).toLowerCase();
        } else {
            return name;
        }
    }
}
