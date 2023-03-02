public class Player implements Comparable<Player> {
    private String name;
    private int guessNumber;
    private int trueGuessNumber;

    public Player(String name) {
        this.name = name;
        this.guessNumber = 0;
        this.trueGuessNumber = 0;
    }

    public String getName() {
        return name;
    }

    public int getGuessNumber() {
        return guessNumber;
    }

    public void setGuessNumber() {
        this.guessNumber++;
    }

    public int getTrueGuessNumber() {
        return trueGuessNumber;
    }

    public void setTrueGuessNumber() {
        this.trueGuessNumber++;
    }

    @Override
    public int compareTo(Player player) {
        return Integer.compare(player.getGuessNumber(),this.getGuessNumber());
        /*if(this.getGuessNumber() > player.getGuessNumber())
            return -1;
        else if(this.getGuessNumber() < player.getGuessNumber())
            return 1;
        else
            return 0;*/
    }


    @Override
    public String toString() {
        return
                "name= '" + name + '\'' + "\n" +
                        "guessNumber =" + guessNumber + "\n" +
                        "trueGuessNumber=" + trueGuessNumber + "\n" +
                        "------------------------------------------------------\n";
    }
}