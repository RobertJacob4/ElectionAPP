package sample;

/**
 * Responsible for object candidate and parameters of the class.
 */

    public class Candidate {

    private Politician candidate;
    private Election election;
    private int candidateVotes;

    public Candidate(Politician candidate, Election election , int candidateVotes) {
        this.election = election;
        this.candidate = candidate;
        this.candidateVotes = candidateVotes;
    }


    /**
     * Getters and Setters for fields of Candidate class.
     */

    public Politician getCandidate() {
        return candidate;
    }
    public int getCandidateVotes() {
        return candidateVotes;
    }
    public Election getElection() {
        return election;
    }

    public void setCandidate(Politician candidate) {
        this.candidate = candidate;
    }

    public void setElection(Election election) {
        this.election = election;
    }

    public void setCandidateVotes(int candidateVotes) {
        this.candidateVotes = candidateVotes;
    }



    @Override
    public String toString() {
        return "Candidate{" +
                "candidate=" + candidate +
                ", election=" + election +
                ", candidateVotes=" + candidateVotes +
                '}';
    }
}
