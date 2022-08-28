package jp.com.app.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.com.app.dto.*;
import jp.com.app.entity.*;
import jp.com.app.mapper.*;

@Service
public class SampleService1Impl implements SampleService1 {
    @Autowired
    Sample1Mapper mapper;

    /*
     * DBからユーザ情報を取得する
     * return ユーザ情報のリスト
     */
    @Override
    public List<SampleDto1Response> getSelectSql() {
        /** DBからデータを取得(SELECT文を発行)*/
        List<SampleEntity1Response> resultList = mapper.selectSql();

        /** 画面返却レスポンスリストの初期化 */
        List<SampleDto1Response> responseList = new LinkedList<SampleDto1Response>();
        
        /** DBから取得したデータを画面返却レスポンス用の型に変換して、リストにセット */
        for(SampleEntity1Response result : resultList){
            SampleDto1Response response = new SampleDto1Response(
                result.getId().toString(),
                result.getName()
            );
            responseList.add(response);
        }

        return responseList;
    }

    /**
     * ユーザ情報を追加する
     * @param request 画面リクエスト
     */
    @Override
    public void getInsertSql(SampleDto1Request request) {
        /** 画面から送られてきたデータをDBのリクエストエンティティに変換する */
        SampleEntity1Request entityRequest = new SampleEntity1Request(
            Integer.parseInt(request.getId()),
            request.getName()
        );

        /** テーブルにデータを追加(INSERT文を発行) */
        mapper.insertSql(entityRequest);
    }

    /**
     * ユーザ情報を更新する
     * @param request 画面リクエスト
     */
    @Override
    public void getUpdateSql(SampleDto1Request request) {
        /** 画面から送られてきたデータをDBのリクエストエンティティに変換する */
        SampleEntity1Request entityRequest = new SampleEntity1Request(
            Integer.parseInt(request.getId()),
            request.getName()
        );

        /** テーブルにデータを更新(Update文を発行) */
        mapper.updateSql(entityRequest);    
    }

    /**
     * ユーザ情報を削除する
     * @param request 画面リクエスト
     */
    @Override
    public void getDeleteSql(SampleDto1Request request) {
        /** 画面から送られてきたデータをDBのリクエストエンティティに変換する */
        SampleEntity1Request entityRequest = new SampleEntity1Request();
        entityRequest.setId(Integer.parseInt(request.getId()));

        /** テーブルにデータを削除(DELETE文を発行) */
        mapper.deleteSql(entityRequest);       
    }
}
