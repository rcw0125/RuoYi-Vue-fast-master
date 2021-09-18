package com.ruoyi.project.system.mapper;

import java.util.List;
import com.ruoyi.project.system.domain.BlogArticle;

/**
 * 博客文章Mapper接口
 * 
 * @author ruoyi
 * @date 2021-06-30
 */
public interface BlogArticleMapper 
{
    /**
     * 查询博客文章
     * 
     * @param id 博客文章ID
     * @return 博客文章
     */
    public BlogArticle selectBlogArticleById(Long id);

    /**
     * 查询博客文章列表
     * 
     * @param blogArticle 博客文章
     * @return 博客文章集合
     */
    public List<BlogArticle> selectBlogArticleList(BlogArticle blogArticle);

    /**
     * 新增博客文章
     * 
     * @param blogArticle 博客文章
     * @return 结果
     */
    public int insertBlogArticle(BlogArticle blogArticle);

    /**
     * 修改博客文章
     * 
     * @param blogArticle 博客文章
     * @return 结果
     */
    public int updateBlogArticle(BlogArticle blogArticle);

    /**
     * 删除博客文章
     * 
     * @param id 博客文章ID
     * @return 结果
     */
    public int deleteBlogArticleById(Long id);

    /**
     * 批量删除博客文章
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBlogArticleByIds(Long[] ids);
}
