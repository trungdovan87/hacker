package com.kamereo.account.problem;

import com.kamereo.account.lib.VisibleForTesting;

import java.io.*;
import java.util.List;
import java.util.Set;

public class Solution {
    private static final String CEO = "CEO";
    private static final String ADD = "ADD";
    private static final String REMOVE = "REMOVE";
    private static final String QUERY = "QUERY";

    private void printPermission(Set<String> permissions) {
        getPrintStream().println(String.join(",", permissions));
    }

    private int convert(String line) {
        return CEO.equals(line) ? 0 : Integer.parseInt(line.trim());
    }

    @VisibleForTesting
    InputStream getInputStream() {
        return System.in;
    }

    @VisibleForTesting
    PrintStream getPrintStream() {
        return System.out;
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(getInputStream()));
        int n = Integer.parseInt(br.readLine().trim()) + 1;

        Problem problem = new Problem(n);

        for (int i = 0; i < n; i++) {
            problem.addPermission(i, br.readLine().split(" "));
        }

        for (int u = 1; u < n; u++) {
            String line = br.readLine();
            int v = convert(line);
            problem.addEdge(u, v);
        }

        problem.process();

        List<Set<String>> result = problem.calculateAll();
        result.forEach(this::printPermission);

        boolean quit = false;
        while (!quit) {
            String[] cmd = br.readLine().split(" ");
            switch (cmd[0].toUpperCase()) {
                case ADD:
                    int u = convert(cmd[1]);
                    String permission = cmd[2];
                    problem.commandAdd(u, permission);
                    break;
                case REMOVE:
                    u = convert(cmd[1]);
                    permission = cmd[2];
                    problem.commandRemove(u, permission);
                    break;
                case QUERY:
                    u = convert(cmd[1]);
                    printPermission(problem.commandQuery(u));
                    break;
                default:
                    quit = true;
                    break;
            }
        }
    }
}
