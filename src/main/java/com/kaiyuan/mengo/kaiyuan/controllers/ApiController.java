package com.kaiyuan.mengo.kaiyuan.controllers;

import com.kaiyuan.mengo.kaiyuan.entity.UserGallery;
import com.kaiyuan.mengo.kaiyuan.services.UserGalleryService;
import com.kaiyuan.mengo.kaiyuan.utility.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class ApiController {
    private static final Logger logger = LoggerFactory.getLogger(ApiController.class);

    @Autowired
    private UserGalleryService userGalleryService;//用户图库的服务


    /**
     * @param nodeLabelList 显示的节点的类型  string[]  all
     * @param edgeLabelList 显示的边的类型  string[] all
     * @param maxDegree  显示的节点的最大度 int 0
     * @param minDegree  显示的节点的最小度 int null
     * 过滤图参数接收，处理并返回结果
     */
    @PostMapping("filtered")
    public String filtered(String titlePropertyName,String nodeValueExpr,String edgeValueExpr,String showEdgeLabel,String showImage,String nodeImageExpr,String initialScale ,String nodeLabelList,String edgeLabelList,String minDegree,String maxDegree){
            logger.info(nodeLabelList+"\n"+edgeLabelList+"\n"+minDegree+"\n"+maxDegree);
            return CommonResult.success();
    }

    /**
     * 高级过滤图
     * @param cypher  查询语句 string 必填
     * @return 返回结果
     */
    @PostMapping("advanced_filtered")
    public String advancedFiltered(String titlePropertyName,String nodeValueExpr,String edgeValueExpr,String showEdgeLabel,String showImage,String nodeImageExpr,String initialScale ,String cypher){
        logger.info(cypher);
        return CommonResult.success();
    }

    /**
     * 抽样图
     * @param sampleSize 取样实体总数 int 必填
     * @return 返回结果
     */
    @PostMapping("sample")
    public String sample(String titlePropertyName,String nodeValueExpr,String edgeValueExpr,String showEdgeLabel,String showImage,String nodeImageExpr,String initialScale ,@RequestParam(value = "sampleSize") String sampleSize){
        logger.info(sampleSize);
        return CommonResult.success();
    }

    /**
     * 社区图
     * @param nodeLabelList 计算的节点的类型 string[] all
     * @param topN 选取topN个社区 int  null
     * @param minCommunitySize  最小社区规模 int  null
     * @param communityBackgroundColors 显示社区轮廓底色 string[] rgba()
     * @param communityBorderColors 显示社区轮廓色 string  null
     * @param allowOverlap 允许重叠 boolean false
     * @return 返回结果
     */
    @PostMapping("community")
    public String community(String titlePropertyName,String nodeValueExpr,String edgeValueExpr,String showEdgeLabel,String showImage,String nodeImageExpr,String initialScale ,String nodeLabelList,String topN,String minCommunitySize,String communityBackgroundColors,String communityBorderColors,String allowOverlap){
        logger.info(nodeLabelList+"\n"+topN+"\n"+minCommunitySize+"\n"+communityBackgroundColors+"\n"
        +communityBorderColors+"\n"+allowOverlap);
        return CommonResult.success();
    }

    /**
     * 步进探索图
     * @param initialNodelds 默认显示的节点id列表 string[] all
     * @return
     */
    @PostMapping("stepping")
    public String stepping(String titlePropertyName,String nodeValueExpr,String edgeValueExpr,String showEdgeLabel,String showImage,String nodeImageExpr,String initialScale ,String initialNodelds){
        logger.info(initialNodelds);
        return CommonResult.success();
    }

    /**
     * 关联路径图
     * @param initialNodelds  默认显示的节点id列表 string[] all
     * @param initialDepth 默认最大深度 int 6
     * @return
     */
    @PostMapping("relate")
    public String relate(String titlePropertyName,String nodeValueExpr,String edgeValueExpr,String showEdgeLabel,String showImage,String nodeImageExpr,String initialScale ,String initialNodelds,String initialDepth){
        logger.info(initialNodelds+"\n"+initialDepth);
        return CommonResult.success();
    }

    /**
     * 获取当前用户所有的图库数据
     */
    @GetMapping("getGallery")
    public String getGallery(){
        return userGalleryService.findAll();
    }
}
