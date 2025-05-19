public class MinimumTimeCollectGarbage2391 {

    public int garbageCollection(String[] garbage, int[] travel) {
        int totalTime = 0, lastM = -1, lastP = -1, lastG = -1, countM = 0, countP = 0, countG = 0;

        for (int i = 0; i < garbage.length; i++) {
            String current = garbage[i];
            if (current.contains("M")) {
                lastM = i;
                countM += current.length() - current.replace("M", "").length();
            }
            if (current.contains("P")) {
                lastP = i;
                countP += current.length() - current.replace("P", "").length();
            }
            if (current.contains("G")) {
                lastG = i;
                countG += current.length() - current.replace("G", "").length();
            }
        }

        totalTime += countM + countP + countG;
        totalTime += sumTravelTime(travel, lastM);
        totalTime += sumTravelTime(travel, lastP);
        totalTime += sumTravelTime(travel, lastG);

        return totalTime;
    }

    private int sumTravelTime(int[] travel, int lastHouse) {
        if (lastHouse <= 0) return 0;
        int sum = 0;
        for (int i = 0; i < lastHouse; i++) {
            sum += travel[i];
        }
        return sum;
    }
}
