package jp.ac.morijyobi.book_management.service.impl;

import jp.ac.morijyobi.book_management.bean.entity.Tag;
import jp.ac.morijyobi.book_management.bean.form.TagForm;
import jp.ac.morijyobi.book_management.mapper.TagMapper;
import jp.ac.morijyobi.book_management.service.TagService;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl implements TagService {
    private final TagMapper tagMapper;

    public TagServiceImpl(TagMapper tagMapper) {
        this.tagMapper = tagMapper;
    }

    @Override
    public Tag registerTag(TagForm tagForm) {
        Tag tag = new Tag();
        tag.setTagName(tagForm.getTagName());

        return null;
    }
}