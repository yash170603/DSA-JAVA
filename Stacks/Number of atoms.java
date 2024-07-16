import java.util.*;

class Solution {
    public String countOfAtoms(String formula) {
        Map<String, Integer> map = parseFormula(formula);
        StringBuilder result = new StringBuilder();
        
        // Sort keys lexicographically
        TreeMap<String, Integer> sortedMap = new TreeMap<>(map);
        
        for (String atom : sortedMap.keySet()) {
            result.append(atom);
            int count = sortedMap.get(atom);
            if (count > 1) {
                result.append(count);
            }
        }
        
        return result.toString();
    }

    private Map<String, Integer> parseFormula(String formula) {
        Stack<Map<String, Integer>> stack = new Stack<>();
        Map<String, Integer> currentMap = new HashMap<>();
        int i = 0;
        int n = formula.length();
        
        while (i < n) {
            char ch = formula.charAt(i);
            
            if (ch == '(') {
                stack.push(currentMap);
                currentMap = new HashMap<>();
                i++;
            } else if (ch == ')') {
                int iStart = ++i;
                int multiplicity = 1;  // Default multiplicity
                while (i < n && Character.isDigit(formula.charAt(i))) i++;
                if (i > iStart) multiplicity = Integer.parseInt(formula.substring(iStart, i));
                
                if (!stack.isEmpty()) {
                    Map<String, Integer> tempMap = currentMap;
                    currentMap = stack.pop();
                    for (String key : tempMap.keySet()) {
                        currentMap.put(key, currentMap.getOrDefault(key, 0) + tempMap.get(key) * multiplicity);
                    }
                }
            } else {
                int iStart = i++;
                while (i < n && Character.isLowerCase(formula.charAt(i))) i++;
                String name = formula.substring(iStart, i);
                iStart = i;
                while (i < n && Character.isDigit(formula.charAt(i))) i++;
                int multiplicity = i > iStart ? Integer.parseInt(formula.substring(iStart, i)) : 1;
                currentMap.put(name, currentMap.getOrDefault(name, 0) + multiplicity);
            }
        }
        
        return currentMap;
    }
    
    
}
