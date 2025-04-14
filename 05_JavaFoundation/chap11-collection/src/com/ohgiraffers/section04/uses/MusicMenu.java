package com.ohgiraffers.section04.uses;

import java.sql.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MusicMenu {
    private MusicManager musicManager = new MusicManager();
    private Scanner sc = new Scanner(System.in);

    public void mainMenu()
    {
        musicManager.fileLoad();

        mainMenu:
        while(true)
        {
            System.out.println("======= 메뉴 =======");
            System.out.println("1. 곡 추가");
            System.out.println("2. 곡 전체 조회");
            System.out.println("3. 정렬하여 조회");
            System.out.println("4. 가수명으로 검색");
            System.out.println("5. 곡명으로 검색");
            System.out.println("6. 곡 정보 수정");
            System.out.println("7. 곡 삭제");
            System.out.println("8. 프로그램 종료");

            System.out.print("메뉴 선택: ");

            int menu = sc.nextInt();
            sc.nextLine();

            switch (menu)
            {
                case 1:
                    addList();
                    break;
                case 2:
                    selectList();
                    break;
                case 3:
                    sortMenu();
                    break;
                case 4:
                    searchArtist();
                    break;
                case 5:
                    searchTitle();
                    break;
                case 6:
                    updateMusic();
                    break;
                case 7:
                    removeMusic();
                    break;
                case 8:
                    System.out.println("프로그램을 종료합니다.");
                    return;
            }
        }
    }

    public void addList()
    {
        System.out.println(" ==== 곡 추가 ==== ");
        System.out.print("가수 입력: ");
        String artist = sc.nextLine();
        System.out.print("제목 입력: ");
        String title = sc.nextLine();

        musicManager.addList(new MusicDTO(artist, title));
    }

    public void selectList()
    {
        System.out.println("==== 곡 전체 조회 ====");
        List<MusicDTO> musicList = musicManager.selectList();

        if(!musicList.isEmpty())
        {
            for (MusicDTO music : musicList)
            {
                System.out.println(music);
            }
        }
        else
            System.out.println("목록이 존재하지 않습니다.");
    }

    public void sortMenu()
    {
        System.out.println(" ====== 정렬 메뉴 ======");
        System.out.println(" 1. 가수명 오름차순 정렬");
        System.out.println(" 2. 곡명 오름차순 정렬");
        System.out.println(" 3. 가수명 내림차순 정렬");
        System.out.println(" 4. 곡명 내림차순 정렬");
        System.out.print("메뉴 선택 : ");
        int menu = sc.nextInt();

        ascDesc(menu);
    }

    public void ascDesc(int menu)
    {
        System.out.println(" ==== 정렬하여 조회 ==== ");
        List<MusicDTO> musicList = musicManager.selectList();

        if(musicList.isEmpty())
        {
            System.out.println("목록이 존재하지 않습니다.");
            return;
        }
        /** 정렬 시 원본 데이터를 변경하므로 사본 데이터를 별도로 생성한다. */
        List<MusicDTO> sortList = new ArrayList<>();
        sortList.addAll(musicList);

        if (menu == 1)
        {
            /** 익명 클래스 사용 */
            sortList.sort(new Comparator<MusicDTO>() {
                @Override
                public int compare(MusicDTO o1, MusicDTO o2) {
                    return o1.getArtist().compareTo(o2.getArtist());
                }
            });
        }
        else if (menu == 2)
        {
            /** Comparator를 상속한 클래스 사용 */
            sortList.sort(new AscTitle());
        }
        else if (menu == 3)
        {
            sortList.sort(new DescArtist());
        }
        else
        {
            sortList.sort(new DescTitle());
        }

        for (int i = 0; i < sortList.size(); i++)
        {
            System.out.println(sortList.get(i));
        }
    }

    public void searchArtist()
    {
        System.out.print("가수명을 입력하세요: ");
        String artist = sc.nextLine();
        List<MusicDTO> list = musicManager.searchArtist(artist);
        if (!list.isEmpty())
        {
            for (int i = 0; i < list.size(); i++)
            {
                System.out.println(list.get(i));
            }
        }
        else
            System.out.println("찾는 곡이 없습니다.");
    }

    public void searchTitle()
    {
        System.out.print("곡명을 입력하세요: ");
        String title = sc.nextLine();
        List<MusicDTO> list = musicManager.searchTitle(title);
        if (!list.isEmpty())
        {
            for (int i = 0; i < list.size(); i++)
            {
                System.out.println(list.get(i));
            }
        }
        else
            System.out.println("찾는 곡이 없습니다.");
    }

    public void updateMusic()
    {
        for (int i = 0; i < musicManager.selectList().size(); i++)
        {
            System.out.println(i + 1 + ": " + musicManager.selectList().get(i));
        }
        System.out.println("어떤 곡을 수정하시겠습니까? 번호를 입력하세요: ");
        int select = sc.nextInt();
        System.out.println("1. 해당 곡의 가수명 수정하기 2. 해당 곡의 곡명 수정하기");
        int select2 = sc.nextInt();
        System.out.print("수정할 내용을 입력하세요: ");
        sc.nextLine();
        String str = sc.nextLine();
        if (select2 == 1)
            musicManager.selectList().get(select - 1).setArtist(str);
        else if (select2 == 2)
            musicManager.selectList().get(select - 1).setTitle(str);
    }

    public void removeMusic()
    {
        for (int i = 0; i < musicManager.selectList().size(); i++)
        {
            System.out.println(i + 1 + ": " + musicManager.selectList().get(i));
        }
        System.out.println("어떤 곡을 삭제하시겠습니까? 번호를 입력하세요: ");
        int select = sc.nextInt();

        musicManager.selectList().remove(select - 1);
        System.out.println("삭제되었습니다.");
    }
}
