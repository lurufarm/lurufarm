package com.ohgiraffers.section04.uses;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MusicManager {

    private List<MusicDTO> musicList;

    /** 파일 로드 */
    public void fileLoad()
    {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("musicList.dat")))
        {}
        catch (FileNotFoundException e)
        {
            musicList = new ArrayList<>();
        }
        catch (IOException e)
        {
            musicList = new ArrayList<>();
        }
    }
    /** 파일 저장 */
    public void fileSave()
    {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("musicList.dat")))
        {}
        catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    /** 곡 추가 */
    public void addList(MusicDTO music)
    {
        musicList.add(music);
    }

    /** 곡 전체 조회 */
    public List<MusicDTO> selectList()
    {
        return musicList;
    }

    public List<MusicDTO> searchArtist(String artist)
    {
        List<MusicDTO> results = new ArrayList<>();

        for (MusicDTO m : musicList)
        {
            if(m.getArtist().compareTo(artist) == 0)
                results.add(m);
        }

        if (results.isEmpty())
            System.out.println("찾는 곡이 없습니다.");

        return results;
    }

    public List<MusicDTO> searchTitle(String title)
    {
        List<MusicDTO> results = new ArrayList<>();

        for (MusicDTO m : musicList)
        {
            if(m.getTitle().compareTo(title) == 0)
                results.add(m);
        }

        if (results.isEmpty())
            System.out.println("찾는 곡이 없습니다.");;

        return results;
    }
}
