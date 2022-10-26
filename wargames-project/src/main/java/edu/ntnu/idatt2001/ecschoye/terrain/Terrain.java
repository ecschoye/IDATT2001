package edu.ntnu.idatt2001.ecschoye.terrain;

import java.util.*;
/**
 * Class Terrain
 * @author Edvard Schøyen
 *
 */
public enum Terrain {
    HILL,
    PLAINS,
    FOREST;

    private static final List<Terrain> TERRAINS = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = TERRAINS.size();
    private static final Random RANDOM = new Random();

    /**
     * Method that returns a random terrain
     * @return
     */
    public static Terrain randomTerrain(){
        return TERRAINS.get(RANDOM.nextInt(SIZE));
    }
}
