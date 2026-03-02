    import java.util.*;

    /**
     * Gestioneaza o instanta a problemei (locatii si drumuri).
     */
    public class Problem {
        private List<Location> locations = new ArrayList<>();
        private List<Road> roads = new ArrayList<>();

        public void addLocation(Location loc) {
            if (!locations.contains(loc)) {
                locations.add(loc);
            } else {
                System.out.println("Locatia " + loc + " exista deja!");
            }
        }

        public void addRoad(Road road) {
            if (!roads.contains(road)) {
                roads.add(road);
            } else {
                System.out.println("Drumul " + road + " exista deja!");
            }
        }

        /**
         * Verifica daca instanta este valida.
         */
        public boolean isValid() {
            return locations.size() >= 2 && !roads.isEmpty();
        }

        /**
         * Algoritm simplu pentru a verifica daca se poate ajunge de la start la end.
         */
        public boolean canReach(Location start, Location end) {
            Set<Location> visited = new HashSet<>();
            Queue<Location> queue = new LinkedList<>();

            queue.add(start);
            visited.add(start);

            while (!queue.isEmpty()) {
                Location current = queue.poll();
                if (current.equals(end))
                    return true;

                for (Road road : roads) {
                    if (road.getFrom().equals(current) && !visited.contains(road.getTo())) {
                        visited.add(road.getTo());
                        queue.add(road.getTo());
                    }
                }
            }
            return false;
        }
    }