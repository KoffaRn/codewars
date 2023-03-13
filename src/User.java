public class User {
    int rank;
    int progress;

    public User() {
        rank = -8;
        progress = 0;
    }
    void incProgress(int rank)  throws  ArithmeticException  {
        if(rank < -8 || rank > 8) throw new ArithmeticException("Rank exceeded range.");
        else {
            int tmpPoints = 0;
            int diff = rank - this.rank;
            if(rank > 0 && this.rank < 0) diff -= 1;
            if(rank == this.rank) tmpPoints += 3;
            else if(rank >= this.rank - 2) tmpPoints += 1;
            else if(rank > this.rank) tmpPoints += diff * diff * 10;
            progress += tmpPoints;
            rankUp();
        }
    }
    void rankUp(){
        while(progress >= 100) {
            if(progress < 100) {
                return;
            }
            rank += 1;
            if(rank == 0) rank += 1;
            progress -= 100;

        }

    }
    @Override
    public String toString() {
        return "User progress: " + progress + " User rank: " + rank;
    }
}