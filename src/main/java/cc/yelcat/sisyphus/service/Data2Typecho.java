package cc.yelcat.sisyphus.service;

import cc.yelcat.sisyphus.entity.TypechoContents;
import cc.yelcat.sisyphus.entity.TypechoRelationships;
import cc.yelcat.sisyphus.mapper.TypechoContentsMapper;
import cc.yelcat.sisyphus.mapper.TypechoRelationshipsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

@Service
public class Data2Typecho {
    @Autowired
    private TypechoContentsMapper typechoContentsMapper;
    @Autowired
    private TypechoRelationshipsMapper typechoRelationshipsMapper;

    @Transactional
    public void data2Mysql(String directoryPath) {

        File baseFile = new File(directoryPath);
        if (baseFile.isFile() || !baseFile.exists()) {
            return;
        }
        File[] files = baseFile.listFiles();
        assert files != null;
        for (File file : files) {
            if (file.getName().contains(".md")) {
                TypechoContents typechoContents = new TypechoContents();
                typechoContents.setTitle(file.getName().split(".md")[0]);
                typechoContents.setText(txt2String(file));
                typechoContents.setAuthorid(1);
                typechoContents.setAllowfeed("1");
                typechoContents.setAllowping("1");
                typechoContents.setAllowcomment("1");
                typechoContentsMapper.insertSelective(typechoContents);
                System.out.println(file.getName()+"     "+  typechoContents.getCid());
                TypechoRelationships typechoRelationships = new TypechoRelationships();
                typechoRelationships.setCid(typechoContents.getCid());
                typechoRelationships.setMid(3);
                typechoRelationshipsMapper.insertSelective(typechoRelationships);

            }


        }
    }


    public static String txt2String(File file){
        StringBuilder result = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            result.append("<!--markdown-->");
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                result.append(System.lineSeparator()+s);
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return result.toString();
    }


}
