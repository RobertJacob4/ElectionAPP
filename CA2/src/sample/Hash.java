package sample;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Hash {
    Politician politician;
    Election election;
    Candidate candidate;

    int politicianCurrentSize = 0;
    int politicianArraySize = 31;
    Politician[] politiciansArray = new Politician[politicianArraySize];

    int electionCurrentSize = 0;
    int electionArraySize = 31;
    Election[] electionsArray = new Election[electionArraySize];

    int candidateCurrentSize = 0;
    int candidateArraySize = 31;
    Candidate[] candidatesArray = new Candidate[electionArraySize];



    public void politicianHashFunction(Politician politician, Politician[] politiciansArray) {

        int pHashIndex = -1;


        for (int i = 0; i < politician.getPoliticianName().length(); i++) {
            pHashIndex = pHashIndex + politician.getPoliticianName().charAt(i);

        }
        pHashIndex = pHashIndex % politicianArraySize;

        System.out.println("Modulus Index= " + pHashIndex + " for value " + politician);

        while (politiciansArray[pHashIndex] != null) {

            ++pHashIndex;

            System.out.println("Collision Try " + pHashIndex + " Instead");

            // If we get to the end of the array go back to index 0

            pHashIndex %= politicianArraySize;

        }
        politiciansArray[pHashIndex] = politician;
        politicianCurrentSize++;
        reHashPolitician();
    }


    public void reHashPolitician() {

        if (politicianCurrentSize / politicianArraySize > 0.75) {

            Politician[] temp = politiciansArray;
            politicianArraySize = politicianArraySize + 15;
            politiciansArray = new Politician[politicianArraySize];
            politicianCurrentSize = 0;

            for (int i = 0; i < temp.length; i++) {
                politiciansArray[i] = temp[i];
            }

        }

    }


    public Politician findPoliticianKey(String key) {
        int hashIndex = -1;
        // Find the keys original hash key
        for (int i = 0; i < key.length(); i++) {
            hashIndex = hashIndex + key.charAt(i);
            politicianCurrentSize++;
        }
        int arrayIndexHash = hashIndex % 31;

        while (politiciansArray[arrayIndexHash] != null) {
            if (politiciansArray[arrayIndexHash].getPoliticianName().equals(key)) {
                // Found the key so return it
                System.out.println(key + " was found in index " + arrayIndexHash);
                return politiciansArray[arrayIndexHash];
            }
            // Look in the next index
            ++arrayIndexHash;
            // If we get to the end of the array go back to index
            arrayIndexHash %= politicianArraySize;
        }
        // Couldn't locate the key
        return null;
    }

    public void fillPolitician() {
        Politician p = null;
        Arrays.fill(politiciansArray, p);
    }

/////////////////// ELECTION HASH FUNCTION ETC.

    public void electionHashFunction(Election election, Election[] electionsArray) {


        int eHashIndex = -1;

        for (int i = 0; i < election.getElectionDate().length() + election.getElectionType().length(); i++) {
            String s= election.getElectionDate().concat(election.getElectionType());
            eHashIndex = eHashIndex + s.charAt(i);

        }
        eHashIndex = eHashIndex % electionArraySize;

        System.out.println("Modulus Index= " + eHashIndex + " for value " + election);

        while (electionsArray[eHashIndex] != null) {

            ++eHashIndex;

            System.out.println("Collision Try " + eHashIndex + " Instead");

            // If we get to the end of the array go back to index 0

            eHashIndex %= electionArraySize;

        }
        electionsArray[eHashIndex] = election;
        electionCurrentSize++;
        reHashElection();
    }


    public void reHashElection() {

        if (electionCurrentSize / electionArraySize > 0.75) {

            Election[] temp = electionsArray;
            electionArraySize = electionArraySize + 15;
            electionsArray = new Election[electionArraySize];
            electionCurrentSize = 0;

            for (int i = 0; i < temp.length; i++) {
                electionsArray[i] = temp[i];
            }

        }

    }


    public Election findElectionKey(String key ,String key2) {
        int hashIndex = -1;
        // Find the keys original hash key
        for (int i = 0; i < key.length() + key2.length(); i++) {
            String s=key.concat(key2);
            hashIndex = hashIndex + s.charAt(i);
            electionCurrentSize++;
        }
        int arrayIndexHash = hashIndex % 31;

        while (electionsArray[arrayIndexHash] != null) {
            if (key2.contains(electionsArray[arrayIndexHash].getElectionType()) && key.contains(electionsArray[arrayIndexHash].getElectionDate())) {
                // Found the key so return it
                System.out.println(key + " was found in index " + arrayIndexHash);
                return electionsArray[arrayIndexHash];
            }
            // Look in the next index
            ++arrayIndexHash;
            // If we get to the end of the array go back to index
            arrayIndexHash %= electionArraySize;
        }
        // Couldn't locate the key
        return null;
    }

    public void fillElection() {
        Election p = null;
        Arrays.fill(electionsArray, p);
    }



    ////////////////////////////////////////////candidate


    public void candidateHashFunction(Candidate candidate, Candidate[] candidatesArray) {

        int cHashIndex = -1;


        for (int i = 0; i < candidate.getCandidate().getPoliticianName().length(); i++) {
            cHashIndex = cHashIndex + candidate.getCandidate().getPoliticianName().charAt(i);

        }
        cHashIndex = cHashIndex % candidateArraySize;

        System.out.println("Modulus Index= " + cHashIndex + " for value " + candidate);

        while (candidatesArray[cHashIndex] != null) {

            ++cHashIndex;

            System.out.println("Collision Try " + cHashIndex + " Instead");

            // If we get to the end of the array go back to index 0

            cHashIndex %= candidateArraySize;

        }
        candidatesArray[cHashIndex] = candidate;
        candidateCurrentSize++;
        reHashCandidate();
    }


    public void reHashCandidate() {
        if (candidateCurrentSize / candidateArraySize > 0.75) {

            Candidate[] temp = candidatesArray;
            candidateArraySize = candidateArraySize + 15;
            candidatesArray= new Candidate[candidateArraySize];

            for (int i = 0; i < temp.length; i++) {
                candidatesArray[i] = temp[i];
            }

        }

    }


    public Candidate findCandidateKey(String key) {
        int hashIndex = -1;
        // Find the keys original hash key
        for (int i = 0; i < key.length(); i++) {
            hashIndex = hashIndex + key.charAt(i);
            candidateCurrentSize++;
        }
        int arrayIndexHash = hashIndex % 31;

        while (candidatesArray[arrayIndexHash] != null) {
            if (candidatesArray[arrayIndexHash].getCandidate().getPoliticianName().equals(key)) {
                // Found the key so return it
                System.out.println(key + " was found in index " + arrayIndexHash);
                return candidatesArray[arrayIndexHash];
            }
            // Look in the next index
            ++arrayIndexHash;
            // If we get to the end of the array go back to index
            arrayIndexHash %= candidateArraySize;
        }
        // Couldn't locate the key
        return null;
    }

    public void fillCandidate() {
       Candidate p = null;
        Arrays.fill(candidatesArray, p);
    }




    ///////////////////////////////////////////load & Save


    public void savePoliticians() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("Politicians.xml"));
        out.writeObject(politiciansArray);
        out.close();
    }


    public void loadPoliticians() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("Politicians.xml"));
        politiciansArray = (Politician[]) is.readObject();

        is.close();
    }


    public void saveElections() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("Elections.xml"));
        out.writeObject(electionsArray);
        out.close();
    }


    public void loadElections() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("Elections.xml"));
        electionsArray = (Election[]) is.readObject();
        is.close();
    }

    public void saveCandidates() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("Candidates.xml"));
        out.writeObject(candidatesArray);
        out.close();
    }


    public void loadCandidates() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("Candidates.xml"));
        candidatesArray = (Candidate[]) is.readObject();
        is.close();
    }


}