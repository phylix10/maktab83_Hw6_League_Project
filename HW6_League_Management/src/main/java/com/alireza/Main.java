package com.alireza;

import com.alireza.model.Clubs;
import com.alireza.model.FootballMatches;
import com.alireza.model.League;
import com.alireza.model.VolleyballMatches;
import com.alireza.service.FootballService;
import com.alireza.service.LeagueService;
import com.alireza.service.VolleyballService;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        LeagueService leagueService = new LeagueService();
        FootballService footballService = new FootballService();
        VolleyballService volleyballService = new VolleyballService();
        boolean flag = true;

        while (flag){
            printMainMenu();

            System.out.print("Please enter the desired operation number: ");
            int input = scanner.nextInt();

            switch (input){
                case 1:
                    addLeague(leagueService);
                    break;
                case 2:
                    football(footballService);
                    break;
                case 3:
                    volleyball(volleyballService);
                    break;
                case 4:
                    flag = false;
                    break;
                default:
                    System.out.println("You entered the wrong option!");
                    break;
            }
        }
    }
    public static void printMainMenu() {
        System.out.println(
                "――――― Welcome To The League Management System ――――――\n " +
                        "✎ 1. Add New League (Beta)\n " +
                        "✎ 2. Football League\n " +
                        "✎ 3. Volleyball League\n " +
                        "✎ 4. Exit Menu");
    }
    public static void printFootballMenu() {
        System.out.println(
                "――――― Welcome To Persian Golf League ――――――\n " +
                        "✎ 1. Add New Team\n " +
                        "✎ 2. Delete Team\n " +
                        "✎ 3. Play Football Match\n " +
                        "✎ 4. Show Team Detail\n " +
                        "✎ 5. Show League Table\n " +
                        "✎ 6. Exit");
    }
    public static void printVolleyballMenu() {
        System.out.println(
                "――――― Welcome To Volleyball Stars League ――――――\n " +
                        "✎ 1. Add New Team\n " +
                        "✎ 2. Delete Team\n " +
                        "✎ 3. Play Volleyball Match\n " +
                        "✎ 4. Show Team Detail\n " +
                        "✎ 5. Show League Table\n " +
                        "✎ 6. Exit");
    }
    public static void addLeague(LeagueService leagueService){
        System.out.print("Enter the name of the league: ");
        String name = scanner.nextLine();

        System.out.print("Enter the type of league (for example; football): ");
        String type = scanner.nextLine();

        League newLeague = new League(name, type);
        leagueService.addLeague(newLeague);
    }
    public static void football(FootballService footballService){
        boolean flag = true;

        while (flag){
            printFootballMenu();

            System.out.print("Please enter the desired operation number: ");
            int input = scanner.nextInt();

            switch (input){
                case 1:
                    addFootballTeam(footballService);
                    break;
                case 2:
                    deleteFootballTeam(footballService);
                    break;
                case 3:
                    playFootballMatch(footballService);
                    break;
                case 4:
                    showFootballClubDetail(footballService);
                    break;
                case 5:
                    footballService.showTable();
                    break;
                case 6:
                    flag = false;
                    break;
                default:
                    System.out.print("You entered the wrong option!");
                    break;
            }
        }
    }
    public static void volleyball(VolleyballService volleyballService){
        boolean flag = true;

        while (flag){
            printVolleyballMenu();

            System.out.print("Please enter the desired operation number: ");
            int input = scanner.nextInt();

            switch (input){
                case 1:
                    addVolleyballTeam(volleyballService);
                    break;
                case 2:
                    deleteVolleyballTeam(volleyballService);
                    break;
                case 3:
                    playVolleyballMatch(volleyballService);
                    break;
                case 4:
                    showVolleyballClubDetail(volleyballService);
                    break;
                case 5:
                    volleyballService.showTable();
                    break;
                case 6:
                    flag = false;
                    break;
                default:
                    System.out.println("You entered the wrong option!");
                    break;
            }
        }
    }
    public static void addFootballTeam(FootballService footballService){
        League league = new League("persian golf league","football");

        System.out.print("Enter the name of the team: ");
        String clubName = scanner.next();

        System.out.print("Enter the coach's last name: ");
        String coach = scanner.next();

        System.out.print("Enter the name of the stadium: ");
        String stadium = scanner.next();

        System.out.print("Enter the number of players: ");
        int numberOfPlayer = scanner.nextInt();

        System.out.print("Enter the number of cups: ");
        int numberOfCups = scanner.nextInt();

        Clubs newClub = new Clubs(league, clubName, coach, stadium, numberOfPlayer, numberOfCups);
        footballService.addTeam(newClub);
    }
    public static void deleteFootballTeam(FootballService footballService){
        System.out.print("Enter the name of the team: ");
        String clubName = scanner.next();

        Clubs newClub = new Clubs(clubName);
        footballService.deleteTeam(newClub);
    }
    public static void playFootballMatch(FootballService footballService){
        League league = new League("persian golf league","football");

        System.out.print("Enter the name of the first team: ");
        String club1 = scanner.next();
        Clubs hostTeam = new Clubs(club1);

        System.out.print("Enter the number of goals scored by the first team: ");
        int hostGoals = scanner.nextInt();

        System.out.print("Enter the name of the second team: ");
        String club2 = scanner.next();
        Clubs guestTeam = new Clubs(club2);

        System.out.print("Enter the number of goals scored by the second team: ");
        int guestGoals = scanner.nextInt();

        FootballMatches footballMatches = new FootballMatches(league, hostTeam, hostGoals, guestTeam, guestGoals);
        footballService.doMatch(footballMatches);
    }
    public static void showFootballClubDetail(FootballService footballService){
        System.out.print("Enter the name of the team: ");
        String clubName = scanner.next();

        Clubs newClub = new Clubs(clubName);
        footballService.showClubDetail(newClub);
    }
    public static void addVolleyballTeam(VolleyballService volleyballService){
        League newLeague = new League("volleyball stars", "volleyball");

        System.out.print("Enter the name of the team: ");
        String clubName = scanner.next();

        System.out.print("Enter the coach's last name: ");
        String coach = scanner.next();

        System.out.print("Enter the name of the stadium: ");
        String stadium = scanner.next();

        System.out.print("Enter the number of players: ");
        int numberOfPlayer = scanner.nextInt();

        System.out.print("Enter the number of cups: ");
        int numberOfCups = scanner.nextInt();

        Clubs newClub = new Clubs(newLeague, clubName, coach, stadium, numberOfPlayer, numberOfCups);
        volleyballService.addTeam(newClub);
    }
    public static void deleteVolleyballTeam(VolleyballService volleyballService){
        System.out.print("Enter the name of the team: ");
        String clubName = scanner.next();

        Clubs newClub = new Clubs(clubName);
        volleyballService.deleteTeam(newClub);
    }
    public static void playVolleyballMatch(VolleyballService volleyballService){
        League league = new League("volleyball stars", "volleyball");

        System.out.print("Enter the name of the first team: ");
        String club1 = scanner.next();
        Clubs hostTeam = new Clubs(club1);

        System.out.print("Enter the number of sets for the first team (Notice that the sum of the sets is equal to 3 or 4 or 5 (3 0) (3 1) (3 2)): ");
        int hostSets = scanner.nextInt();

        System.out.print("Enter the name of the second team: ");
        String club2 = scanner.next();
        Clubs guestTeam = new Clubs(club2);

        System.out.print("Enter the number of sets for the second team (Notice that the sum of the sets is equal to 3 or 4 or 5 (3 0) (3 1) (3 2)): ");
        int guestSets = scanner.nextInt();

        VolleyballMatches volleyballMatches = new VolleyballMatches(league, hostTeam, hostSets, guestTeam, guestSets);
        volleyballService.doMatch(volleyballMatches);
    }
    public static void showVolleyballClubDetail(VolleyballService volleyballService){
        System.out.print("Enter the name of the team: ");
        String clubName = scanner.next();

        Clubs newClub = new Clubs(clubName);
        volleyballService.showClubDetail(newClub);
    }
}
