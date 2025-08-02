package org.example.Graphs.Breadth_FirstSearch;

import java.util.*;

/*
это задача не с leetcode.com, а из книги грокаем алгоритмы второе издание,
условие:
у вас есть манго и вам нужно их продать, для этого вы обращаетесь к своим друзьям с вопросом -
"можешь продать манго?"  и если он может, то его имя будет заканчиваться буквой m.
и так получается, что на вход мы получаем граф, а на выходе должы вывести
имя ближайшего друга, который продаёт манго
 */
public class Solution {
    public String searchMangoFriend(Map<String, List<String>> graph, String start){
        Set<String> all = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()){
            String current = queue.poll();

            if (all.contains(current)) continue;

            all.add(current);
            if (isSeller(current)) {
                return current;
            } else {
                List<String> friends = graph.get(current);
                if (friends != null) {
                    queue.addAll(friends);
                }
            }
        }
        return "none";
    }

    public boolean isSeller(String name){
        return name != null && name.endsWith("m");
    }
}
