package methods;


import java.util.*;

class DTO {
    int age;
    String name;
    ArrayList<DTO> adjList;

    public DTO(int age, String name) {
        this.age = age;
        this.name = name;
        this.adjList = new ArrayList<>();
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public ArrayList<DTO> getAdjList() {
        return adjList;
    }

    @Override
    public String toString() {
        return "DTO{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

class AgeComparator implements Comparator<DTO> {
    Boolean isAscending;

    public AgeComparator() {
        this.isAscending = true;
    }

    public AgeComparator(Boolean isAscending) {
        this.isAscending = isAscending;
    }

    @Override
    public int compare(DTO o1, DTO o2) {
        if (this.isAscending)
            return o1.getAge() - o2.getAge();
        else
            return o2.getAge() - o1.getAge();
    }
}

class NameComparator implements Comparator<DTO> {
    boolean isAscending;

    public NameComparator(boolean isAscending) {
        this.isAscending = isAscending;
    }

    public NameComparator() {
        this.isAscending = true;
    }

    @Override
    public int compare(DTO o1, DTO o2) {
        if (isAscending)
            return o1.name.compareTo(o2.name);
        else
            return o2.getName().compareTo(o1.getName());
    }
}

class ChainedComprator implements Comparator<DTO> {
    private List<Comparator<DTO>> comparatorList;

    public ChainedComprator(Comparator<DTO>... comparators) {
        this.comparatorList = Arrays.asList(comparators);
    }

    @Override
    public int compare(DTO o1, DTO o2) {
        for (Comparator<DTO> comparator : comparatorList) {
            int result = comparator.compare(o1, o2);
            if (result != 0) return result;
        }
        return 0;
    }
}

public class HowSortBefore8 {
    public static void main(String[] args) {
        ArrayList<String> strList = new ArrayList<>();

        strList.add("c");
        strList.add("b");
        strList.add("a");
        Collections.sort(strList);
        System.out.println(strList);

        ArrayList<DTO> aList = new ArrayList<>();
        aList.add(new DTO(5, "b"));
        aList.add(new DTO(5, "d"));
        aList.add(new DTO(4, "d"));
        aList.add(new DTO(3, "d"));
        aList.add(new DTO(2, "c"));
        aList.add(new DTO(2, "b"));
        aList.add(new DTO(1, "a"));
        ChainedComprator chainedComprator = new ChainedComprator(new AgeComparator(), new NameComparator());
        // System.out.println(aList);

        Collections.sort(aList, chainedComprator);
        System.out.println(aList);

        ChainedComprator ageAsc_nameDes = new ChainedComprator(new AgeComparator(), new NameComparator(false));
        TreeSet<DTO> t = new TreeSet<DTO>(ageAsc_nameDes);
        t.add(new DTO(4, "d"));
        t.add(new DTO(3, "b"));
        t.add(new DTO(2, "a"));
        t.add(new DTO(2, "b"));
        t.add(new DTO(2, "c"));
        System.out.println(t);


    }

}

