package io.khashayar.game.window;

import io.khashayar.game.Door;
import org.python.antlr.op.In;

import java.util.*;
import java.util.stream.Collectors;

public class SizedRandomWindowProvider extends PoolWindowProvider {
    final private int size;

    public SizedRandomWindowProvider(ArrayList<Door> doors, int windowSize) {
        super(doors);
        this.size = windowSize;

        ArrayList<Window> windows = getAllCombinations();
        pool.addAll(windows);
    }


    private ArrayList<Window> getAllCombinations() {
        int[] data = new int[size];

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        int[] doorNoArray = doors.stream().mapToInt(door -> door.number).toArray();

        combinationUtil(doorNoArray, data, 0, 4, 0, size, res);

        ArrayList<Window> windows = new ArrayList<>();

        for (ArrayList<Integer> comb : res) {
            List<Door> doorsInWin = doors.stream().filter(door -> comb.contains(door.number)).collect(Collectors.toList());
            windows.add(new Window(new ArrayList<>(doorsInWin), 1.0 / res.size()));
        }

        return windows;
    }

    static void combinationUtil(int arr[], int data[], int start,
                                int end, int index, int r, ArrayList<ArrayList<Integer>> res) {
        if (index == r) {
            res.add(new ArrayList<>(Arrays.stream(data.clone()).boxed().collect(Collectors.toList())));
            return;
        }

        for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
            data[index] = arr[i];
            combinationUtil(arr, data, i + 1, end, index + 1, r, res);
        }
    }
}
