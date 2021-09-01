import java.util.Arrays;
import java.util.List;

public class DirectoryTree {

    static class Directory {
        String name;
        List<Directory> subdirectories;
        Directory parent;

        public Directory(String name, List<Directory> subdirectories) {
            this.name = name;
            this.subdirectories = subdirectories;
            if (subdirectories != null) {
                for (Directory subdirectory : subdirectories) {
                    subdirectory.parent = this;
                }
            }
        }
    }

    public static void main(String[] args) {

        Directory root = new Directory("C", Arrays.asList(
                new Directory("AMD", null),
                new Directory("BIOS", null),
                new Directory("drivers", null),
                new Directory("Intel", null),
                new Directory("PerfLogs", null),
                new Directory("Program Files", Arrays.asList(
                        new Directory("7-Zip", null),
                        new Directory("AWAST Software", null),
                        new Directory("CDBurnerXP", null)
                )),
                new Directory("Program Files (x86)", null)
        ));

        System.out.println();

    }
}
