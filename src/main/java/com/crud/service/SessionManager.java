package com.crud.service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class SessionManager {

    private static Map<String, HttpSession> sessions = new HashMap<>();

    public static void addSession(String username, HttpSession session) {
        sessions.put(username, session);
    }

    public static void removeSession(String username) {
        sessions.remove(username);
    }

    public static HttpSession getSession(String username) {
        return sessions.get(username);
    }

    public static boolean isValidSession(HttpSession session) {
        return sessions.containsValue(session);
    }
}