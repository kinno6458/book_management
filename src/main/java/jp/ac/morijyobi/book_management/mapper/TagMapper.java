package jp.ac.morijyobi.book_management.mapper;

import jp.ac.morijyobi.book_management.bean.entity.Tag;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface TagMapper {
    @Insert("INSERT INTO tags VALUES(default, #{tagName})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    void insertTag(Tag tag);

}
