package com.ruoyi.project.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 博客文章对象 blog_article
 * 
 * @author ruoyi
 * @date 2021-06-30
 */
public class BlogArticle extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键Id */
    private Long id;

    /** 文章所在分类专栏Id */
    @Excel(name = "文章所在分类专栏Id")
    private String classifyId;

    /** 系统内置技术频道Id */
    @Excel(name = "系统内置技术频道Id")
    private String channelId;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 关键字 */
    @Excel(name = "关键字")
    private String keywords;

    /** 来源 */
    @Excel(name = "来源")
    private String source;

    /** 摘要 */
    @Excel(name = "摘要")
    private String excerpt;

    /** 正文 */
    @Excel(name = "正文")
    private String content;

    /** 浏览次数 */
    @Excel(name = "浏览次数")
    private Long viewHits;

    /** 评论数量 */
    @Excel(name = "评论数量")
    private Long commentQuantity;

    /** 点赞数量 */
    @Excel(name = "点赞数量")
    private Long likesQuantity;

    /** 列表缩略图封面 */
    @Excel(name = "列表缩略图封面")
    private String thumbnail;

    /** 是否审核（默认为true),为false是代表拉黑 */
    @Excel(name = "是否审核", readConverterExp = "是否审核（默认为true),为false是代表拉黑")
    private Integer isAudit;

    /** 是否推荐 */
    @Excel(name = "是否推荐")
    private Integer recommend;

    /** 是否置顶 */
    @Excel(name = "是否置顶")
    private Integer isStickie;

    /** 随笔档案   如2019年1月 */
    @Excel(name = "随笔档案   如2019年1月")
    private String archive;

    /** 随笔类型 */
    @Excel(name = "随笔类型")
    private Long articleType;

    /** 1:MarkDown编辑器  2:富文本编辑器, */
    @Excel(name = "1:MarkDown编辑器  2:富文本编辑器,")
    private Long editor;

    /** 状态：1.暂存;2.发布;3.私密随笔 */
    @Excel(name = "状态：1.暂存;2.发布;3.私密随笔")
    private Long status;

    /** 字数 */
    @Excel(name = "字数")
    private Long wordNumber;

    /** 预计阅读时长 */
    @Excel(name = "预计阅读时长")
    private Long readingTime;

    /** 随笔是否开启评论 */
    @Excel(name = "随笔是否开启评论")
    private Integer commentable;

    /** 创建者ID */
    @Excel(name = "创建者ID")
    private Long createUserId;

    /** 是否删除 */
    @Excel(name = "是否删除")
    private Integer isDeleted;

    /** 删除人id */
    @Excel(name = "删除人id")
    private Long deleteUserId;

    /** 删除时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "删除时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date deleteTime;

    /** 最后修改人Id */
    @Excel(name = "最后修改人Id")
    private Long updateUserId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setClassifyId(String classifyId) 
    {
        this.classifyId = classifyId;
    }

    public String getClassifyId() 
    {
        return classifyId;
    }
    public void setChannelId(String channelId) 
    {
        this.channelId = channelId;
    }

    public String getChannelId() 
    {
        return channelId;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setKeywords(String keywords) 
    {
        this.keywords = keywords;
    }

    public String getKeywords() 
    {
        return keywords;
    }
    public void setSource(String source) 
    {
        this.source = source;
    }

    public String getSource() 
    {
        return source;
    }
    public void setExcerpt(String excerpt) 
    {
        this.excerpt = excerpt;
    }

    public String getExcerpt() 
    {
        return excerpt;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setViewHits(Long viewHits) 
    {
        this.viewHits = viewHits;
    }

    public Long getViewHits() 
    {
        return viewHits;
    }
    public void setCommentQuantity(Long commentQuantity) 
    {
        this.commentQuantity = commentQuantity;
    }

    public Long getCommentQuantity() 
    {
        return commentQuantity;
    }
    public void setLikesQuantity(Long likesQuantity) 
    {
        this.likesQuantity = likesQuantity;
    }

    public Long getLikesQuantity() 
    {
        return likesQuantity;
    }
    public void setThumbnail(String thumbnail) 
    {
        this.thumbnail = thumbnail;
    }

    public String getThumbnail() 
    {
        return thumbnail;
    }
    public void setIsAudit(Integer isAudit) 
    {
        this.isAudit = isAudit;
    }

    public Integer getIsAudit() 
    {
        return isAudit;
    }
    public void setRecommend(Integer recommend) 
    {
        this.recommend = recommend;
    }

    public Integer getRecommend() 
    {
        return recommend;
    }
    public void setIsStickie(Integer isStickie) 
    {
        this.isStickie = isStickie;
    }

    public Integer getIsStickie() 
    {
        return isStickie;
    }
    public void setArchive(String archive) 
    {
        this.archive = archive;
    }

    public String getArchive() 
    {
        return archive;
    }
    public void setArticleType(Long articleType) 
    {
        this.articleType = articleType;
    }

    public Long getArticleType() 
    {
        return articleType;
    }
    public void setEditor(Long editor) 
    {
        this.editor = editor;
    }

    public Long getEditor() 
    {
        return editor;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }
    public void setWordNumber(Long wordNumber) 
    {
        this.wordNumber = wordNumber;
    }

    public Long getWordNumber() 
    {
        return wordNumber;
    }
    public void setReadingTime(Long readingTime) 
    {
        this.readingTime = readingTime;
    }

    public Long getReadingTime() 
    {
        return readingTime;
    }
    public void setCommentable(Integer commentable) 
    {
        this.commentable = commentable;
    }

    public Integer getCommentable() 
    {
        return commentable;
    }
    public void setCreateUserId(Long createUserId) 
    {
        this.createUserId = createUserId;
    }

    public Long getCreateUserId() 
    {
        return createUserId;
    }
    public void setIsDeleted(Integer isDeleted) 
    {
        this.isDeleted = isDeleted;
    }

    public Integer getIsDeleted() 
    {
        return isDeleted;
    }
    public void setDeleteUserId(Long deleteUserId) 
    {
        this.deleteUserId = deleteUserId;
    }

    public Long getDeleteUserId() 
    {
        return deleteUserId;
    }
    public void setDeleteTime(Date deleteTime) 
    {
        this.deleteTime = deleteTime;
    }

    public Date getDeleteTime() 
    {
        return deleteTime;
    }
    public void setUpdateUserId(Long updateUserId) 
    {
        this.updateUserId = updateUserId;
    }

    public Long getUpdateUserId() 
    {
        return updateUserId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("classifyId", getClassifyId())
            .append("channelId", getChannelId())
            .append("title", getTitle())
            .append("keywords", getKeywords())
            .append("source", getSource())
            .append("excerpt", getExcerpt())
            .append("content", getContent())
            .append("viewHits", getViewHits())
            .append("commentQuantity", getCommentQuantity())
            .append("likesQuantity", getLikesQuantity())
            .append("thumbnail", getThumbnail())
            .append("isAudit", getIsAudit())
            .append("recommend", getRecommend())
            .append("isStickie", getIsStickie())
            .append("archive", getArchive())
            .append("articleType", getArticleType())
            .append("editor", getEditor())
            .append("status", getStatus())
            .append("wordNumber", getWordNumber())
            .append("readingTime", getReadingTime())
            .append("commentable", getCommentable())
            .append("createUserId", getCreateUserId())
            .append("createTime", getCreateTime())
            .append("isDeleted", getIsDeleted())
            .append("deleteUserId", getDeleteUserId())
            .append("deleteTime", getDeleteTime())
            .append("updateUserId", getUpdateUserId())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
