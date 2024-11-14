package org.example;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SongService realSongService = new RealSongService();
        SongService songServiceProxy = new SongServiceProxy(realSongService);

        // Song IDs to search for
        List<Integer> songIds = Arrays.asList(1, 2, 3, 4, 5);

        // Search for songs using the proxy server
        long startTimeProxyServer = System.currentTimeMillis();
        for (Integer songId : songIds) {
            songServiceProxy.searchById(songId); // Fetch song from the real server and cache it
            System.out.println("Song metadata retrieved from proxy server for song ID " + songId);
        }
        long endTimeProxyServer = System.currentTimeMillis();
        long timeTakenProxyServer = endTimeProxyServer - startTimeProxyServer;

        // Search for the same songs again using the proxy server to demonstrate caching
        startTimeProxyServer = System.currentTimeMillis();
        for (Integer songId : songIds) {
            songServiceProxy.searchById(songId);// Retrieves the song from cache
            System.out.println("Cached song metadata retrieved from proxy server for song ID " + songId);
        }
        long cachedTimeTakenProxyServer = System.currentTimeMillis() - startTimeProxyServer;

        // Search for songs using the real server
        long startTimeRealServer = System.currentTimeMillis();
        for (Integer songId : songIds) {
            realSongService.searchById(songId);
            System.out.println("Song metadata retrieved from real server for song ID " + songId);
        }
        long endTimeRealServer = System.currentTimeMillis();
        long timeTakenRealServer = endTimeRealServer - startTimeRealServer;

        // Display results to understand the difference
        System.out.println("Total time taken to retrieve songs from proxy server: " + timeTakenProxyServer + " milliseconds");
        System.out.println("Total time taken to retrieve cached songs from proxy server: " + cachedTimeTakenProxyServer + " milliseconds");
        System.out.println("Total time taken to retrieve songs from real server: " + timeTakenRealServer + " milliseconds");
    }
}