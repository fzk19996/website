package com.dzkd.website.controller;

import com.dzkd.website.pojo.*;
import com.dzkd.website.service.ArticleService;
import com.dzkd.website.service.Impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class InfoController {

    private ArticleService<Article> admissionService;
    private ArticleService<Article> departmentService;
    private ArticleService<Article> employInfoService;
    private ArticleService<News> newsService;
    private ArticleService<NewsType> newsTypeService;
    private ArticleService<Article> noticeService;
    private ArticleService<ProfessionalIntroduction> professionalService;
    private ArticleService<Article> schoolService;

    @Autowired
    public InfoController( AdmissionInfoServiceImpl admissionService,
                           DepartmentIntroductionServiceImpl departmentService,
                           EmployInfoServiceImpl employInfoService,
                           NewsServiceImpl newsService,
                           NewsTypeServiceImpl newsTypeService,
                           NoticeServiceImpl noticeService,
                           ProfessionalServiceImpl professionalService,
                           SchoolIntroductionServiceImpl schoolService) {
        this.admissionService = admissionService;
        this.departmentService = departmentService;
        this.employInfoService = employInfoService;
        this.newsService = newsService;
        this.newsTypeService = newsTypeService;
        this.noticeService = noticeService;
        this.professionalService = professionalService;
        this.schoolService = schoolService;
    }

    /**
     * =================================================================================================================
     *                                                    招生信息
     * =================================================================================================================
     */

    @RequestMapping(value = "/admission/{articleId}", method = RequestMethod.GET)
    public R searchAdmissionInfo(@PathVariable(name = "articleId") int articleId) {
        Article article = new Article();
        article.setArticleId(articleId);
        return admissionService.searchArticle(article);
    }

    @RequestMapping(value = "/admission", method = RequestMethod.GET)
    public R showAllAdmissionInfo(int pageNum, int pageSize) {
        return admissionService.showAll(pageNum, pageSize);
    }

    /**
     * =================================================================================================================
     *                                                    院系简介
     * =================================================================================================================
     */

    @RequestMapping(value = "/department/{articleId}", method = RequestMethod.GET)
    public R searchDepartment(@PathVariable(name = "articleId") int articleId) {
        Article article = new Article();
        article.setArticleId(articleId);
        return departmentService.searchArticle(article);
    }

    @RequestMapping(value = "/department", method = RequestMethod.GET)
    public R showAllDepartment(int pageNum, int pageSize) {
        return departmentService.showAll(pageNum, pageSize);
    }

    /**
     * =================================================================================================================
     *                                                     就业信息
     * =================================================================================================================
     */

    @RequestMapping(value = "/employ/{articleId}", method = RequestMethod.GET)
    public R searchEmployInfo(@PathVariable(name = "articleId") int articleId) {
        Article article = new Article();
        article.setArticleId(articleId);
        return employInfoService.searchArticle(article);
    }

    @RequestMapping(value = "/employ", method = RequestMethod.GET)
    public R showAllEmployInfo(int pageNum, int pageSize) {
        return employInfoService.showAll(pageNum, pageSize);
    }

    /**
     * =================================================================================================================
     *                                                         新闻
     * =================================================================================================================
     */

    @RequestMapping(value = "/news/{newsId}", method = RequestMethod.GET)
    public R searchNews(@PathVariable(name = "newsId") int newsId) {
        News news = new News();
        news.setNewsId(newsId);
        return newsService.searchArticle(news);
    }

    @RequestMapping(value = "/news", method = RequestMethod.GET)
    public R showAllNews(int pageNum, int pageSize) {
        return newsService.showAll(pageNum, pageSize);
    }

    /**
     * =================================================================================================================
     *                                                       新闻分类
     * =================================================================================================================
     */

    @RequestMapping(value = "/news/type/{newsTypeId}", method = RequestMethod.GET)
    public R searchNewsType(@PathVariable(name = "newsTypeId") int newsTypeId) {
        NewsType newsType = new NewsType();
        newsType.setTypeId(newsTypeId);
        return newsTypeService.searchArticle(newsType);
    }

    @RequestMapping(value = "/news/type", method = RequestMethod.GET)
    public R showAllNewsType(int pageNum, int pageSize) {
        return newsTypeService.showAll(pageNum, pageSize);
    }

    /**
     * =================================================================================================================
     *                                                       公告
     * =================================================================================================================
     */

    @RequestMapping(value = "/notice/{noticeId}", method = RequestMethod.GET)
    public R searchNotice(@PathVariable(name = "noticeId") int articleId) {
        Article article = new Article();
        article.setArticleId(articleId);
        return noticeService.searchArticle(article);
    }

    @RequestMapping(value = "/notice", method = RequestMethod.GET)
    public R showAllNotice(int pageNum, int pageSize) {
        return noticeService.showAll(pageNum, pageSize);
    }

    /**
     * =================================================================================================================
     *                                                    专业介绍
     * =================================================================================================================
     */

    @RequestMapping(value = "/professional/{professionId}", method = RequestMethod.GET)
    public R searchProfession(@PathVariable(name = "professionId") int professionalIntroductionId) {
        ProfessionalIntroduction professionalIntroduction = new ProfessionalIntroduction();
        professionalIntroduction.setProfessionalId(professionalIntroductionId);
        return professionalService.searchArticle(professionalIntroduction);
    }

    @RequestMapping(value = "/professional", method = RequestMethod.GET)
    public R showAllProfession(int pageNum, int pageSize) {
        return professionalService.showAll(pageNum, pageSize);
    }

    /**
     * =================================================================================================================
     *                                                   学校简介
     * =================================================================================================================
     */

    @RequestMapping(value = "/school", method = RequestMethod.GET)
    public R searchSchool(@RequestBody Article article) {
        return schoolService.searchArticle(article);
    }

}