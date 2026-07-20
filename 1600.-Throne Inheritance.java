import java.util.*;

class ThroneInheritance {
    // Map to represent the family tree: parentName -> list of childNames
    private final Map<String, List<String>> familyTree;
    // Set to keep track of deceased members
    private final Set<String> dead;
    // The starting root of the inheritance
    private final String king;

    public ThroneInheritance(String kingName) {
        this.familyTree = new HashMap<>();
        this.dead = new HashSet<>();
        this.king = kingName;
        this.familyTree.put(kingName, new ArrayList<>());
    }
    
    public void birth(String parentName, String childName) {
        // Add the child to the parent's children list
        this.familyTree.computeIfAbsent(parentName, k -> new ArrayList<>()).add(childName);
    }
    
    public void death(String name) {
        // Mark the person as dead
        this.dead.add(name);
    }
    
    public List<String> getInheritanceOrder() {
        List<String> order = new ArrayList<>();
        dfs(king, order);
        return order;
    }

    private void dfs(String current, List<String> order) {
        // If the current person is alive, they are added to the list
        if (!dead.contains(current)) {
            order.add(current);
        }
        
        // Traverse through all children of the current person in order of birth
        List<String> children = familyTree.get(current);
        if (children != null) {
            for (String child : children) {
                dfs(child, order);
            }
        }
    }
}
