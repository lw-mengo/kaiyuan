package com.kaiyuan.mengo.kaiyuan.controllers;

import com.kaiyuan.mengo.kaiyuan.beans.TaskId;
import com.kaiyuan.mengo.kaiyuan.entity.TaskInfo;
import com.kaiyuan.mengo.kaiyuan.entity.Tasks;
import com.kaiyuan.mengo.kaiyuan.entity.UserGallery;
import com.kaiyuan.mengo.kaiyuan.services.TaskInfoService;
import com.kaiyuan.mengo.kaiyuan.services.TaskService;
import com.kaiyuan.mengo.kaiyuan.services.UserGalleryService;
import com.kaiyuan.mengo.kaiyuan.utility.CommonResult;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 给前端使用的api
 */
@RestController
@RequestMapping("api")
public class ApiController {
    private static final Logger logger = LoggerFactory.getLogger(ApiController.class);

    @Autowired
    private UserGalleryService userGalleryService;//用户图库的服务
    @Autowired
    private TaskInfoService taskInfoService;
    @Autowired
    private TaskService taskService;




    //TODO 所有的图制作都要一个taskID 前端传入，然后根据对应方法制作图，并且保存到数据库

    /**
     * 过滤图
     *
     * @param nodeLabelList     显示的节点的类型  string[]  all
     * @param edgeLabelList     显示的边的类型  string[] all
     * @param maxDegree         显示的节点的最大度 int 0
     * @param minDegree         显示的节点的最小度 int null
     * @param titlePropertyName 作为节点的标题属性 string null
     * @param nodeValueExpr     节点大小 string prop.degree
     * @param edgeValueExpr     边大小 string
     * @param showEdgeLabel     显示边的类别 boolean true
     * @param showImage         在节点显示图片 boolean true
     * @param nodeImageExpr     作为图片的属性字段 string prop.image
     * @param initialScale      初始画面大小 string null
     * @return json                     过滤图参数接收，处理并返回结果
     */
    @PostMapping("filtered")
    public String filtered(String titlePropertyName, String nodeValueExpr, String edgeValueExpr, boolean showEdgeLabel, boolean showImage,
                           String nodeImageExpr, String initialScale, String nodeLabelList, String edgeLabelList, int minDegree,
                           int maxDegree) {
        logger.info(nodeLabelList + "\n" + edgeLabelList + "\n" + minDegree + "\n" + maxDegree);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("titlePropertyName", titlePropertyName);
        jsonObject.put("nodeValueExpr", nodeValueExpr);
        jsonObject.put("edgeValueExpr", edgeValueExpr);
        jsonObject.put("showEdgeLabel", showEdgeLabel);
        jsonObject.put("showImage", showImage);
        jsonObject.put("nodeImageExpr", nodeImageExpr);
        jsonObject.put("initialScale", initialScale);
        jsonObject.put("nodeLabelList", nodeLabelList);
        jsonObject.put("edgeLabelList", edgeLabelList);
        jsonObject.put("minDegree", minDegree);
        UserGallery userGallery = userGalleryService.findByTaskid(TaskId.getTaskId());
        return CommonResult.success(userGallery.getApp1());
    }

    /**
     * 高级过滤图
     *
     * @param cypher 查询语句 string 必填
     * @return 返回结果
     */
    @PostMapping("advanced_filtered")
    public String advancedFiltered(String titlePropertyName, String nodeValueExpr, String edgeValueExpr, boolean showEdgeLabel, boolean showImage, String nodeImageExpr,
                                   String initialScale, String cypher) {
        logger.info(cypher);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("titlePropertyName", titlePropertyName);
        jsonObject.put("nodeValueExpr", nodeValueExpr);
        jsonObject.put("edgeValueExpr", edgeValueExpr);
        jsonObject.put("showEdgeLabel", showEdgeLabel);
        jsonObject.put("showImage", showImage);
        jsonObject.put("nodeImageExpr", nodeImageExpr);
        jsonObject.put("initialScale", initialScale);
        jsonObject.put("cypher", cypher);
        UserGallery userGallery = userGalleryService.findByTaskid(TaskId.getTaskId());
        return CommonResult.success(userGallery.getApp6());
    }

    /**
     * 抽样图
     *
     * @param sampleSize 取样实体总数 int 必填
     * @return 返回结果
     */
    @PostMapping("sample")
    public String sample(String titlePropertyName, String nodeValueExpr, String edgeValueExpr, boolean showEdgeLabel, boolean showImage, String nodeImageExpr,
                         String initialScale, @RequestParam(value = "sampleSize") int sampleSize) {
        logger.info(String.valueOf(sampleSize));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("titlePropertyName", titlePropertyName);
        jsonObject.put("nodeValueExpr", nodeValueExpr);
        jsonObject.put("edgeValueExpr", edgeValueExpr);
        jsonObject.put("showEdgeLabel", showEdgeLabel);
        jsonObject.put("showImage", showImage);
        jsonObject.put("nodeImageExpr", nodeImageExpr);
        jsonObject.put("initialScale", initialScale);
        jsonObject.put("sampleSize", sampleSize);
        UserGallery userGallery = userGalleryService.findByTaskid(TaskId.getTaskId());
        return CommonResult.success(userGallery.getApp5());
    }

    /**
     * 社区图
     *
     * @param nodeLabelList             计算的节点的类型 string[] all
     * @param topN                      选取topN个社区 int  null
     * @param minCommunitySize          最小社区规模 int  null
     * @param communityBackgroundColors 显示社区轮廓底色 string[] rgba()
     * @param communityBorderColors     显示社区轮廓色 string  null
     * @param allowOverlap              允许重叠 boolean false
     * @return 返回结果
     */
    @PostMapping("community")
    public String community(String titlePropertyName, String nodeValueExpr, String edgeValueExpr, boolean showEdgeLabel, boolean showImage, String nodeImageExpr,
                            String initialScale, String nodeLabelList, int topN, int minCommunitySize, String communityBackgroundColors, String communityBorderColors,
                            boolean allowOverlap) {
        logger.info(nodeLabelList + "\n" + topN + "\n" + minCommunitySize + "\n" + communityBackgroundColors + "\n"
                + communityBorderColors + "\n" + allowOverlap);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("titlePropertyName", titlePropertyName);
        jsonObject.put("nodeValueExpr", nodeValueExpr);
        jsonObject.put("edgeValueExpr", edgeValueExpr);
        jsonObject.put("showEdgeLabel", showEdgeLabel);
        jsonObject.put("showImage", showImage);
        jsonObject.put("nodeImageExpr", nodeImageExpr);
        jsonObject.put("initialScale", initialScale);
        jsonObject.put("nodeLableList", nodeLabelList);
        jsonObject.put("topN", topN);
        jsonObject.put("minCommunitySize", minCommunitySize);
        jsonObject.put("communityBackgroundColors", communityBackgroundColors);
        jsonObject.put("communityBorderColors", communityBorderColors);
        jsonObject.put("allowOverlap", allowOverlap);
        UserGallery userGallery = userGalleryService.findByTaskid(TaskId.getTaskId());
        return CommonResult.success(userGallery.getApp4());
    }

    /**
     * 步进探索图
     *
     * @param initialNodelds 默认显示的节点id列表 string[] all
     * @return
     */
    @PostMapping("stepping")
    public String stepping(String titlePropertyName, String nodeValueExpr, String edgeValueExpr, boolean showEdgeLabel, boolean showImage, String nodeImageExpr,
                           String initialScale, String initialNodelds) {
        logger.info(initialNodelds);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("titlePropertyName", titlePropertyName);
        jsonObject.put("nodeValueExpr", nodeValueExpr);
        jsonObject.put("edgeValueExpr", edgeValueExpr);
        jsonObject.put("showEdgeLabel", showEdgeLabel);
        jsonObject.put("showImage", showImage);
        jsonObject.put("nodeImageExpr", nodeImageExpr);
        jsonObject.put("initialScale", initialScale);
        jsonObject.put("initialNodelds", initialNodelds);
        UserGallery userGallery = userGalleryService.findByTaskid(TaskId.getTaskId());
        return CommonResult.success(userGallery.getApp2());
    }

    /**
     * 关联路径图
     *
     * @param initialNodelds 默认显示的节点id列表 string[] all
     * @param initialDepth   默认最大深度 int 6
     * @return
     */
    @PostMapping("relate")
    public String relate(String titlePropertyName, String nodeValueExpr, String edgeValueExpr, boolean showEdgeLabel, boolean showImage, String nodeImageExpr,
                         String initialScale, String initialNodelds, int initialDepth) {
        logger.info(initialNodelds + "\n" + initialDepth);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("titlePropertyName", titlePropertyName);
        jsonObject.put("nodeValueExpr", nodeValueExpr);
        jsonObject.put("edgeValueExpr", edgeValueExpr);
        jsonObject.put("showEdgeLabel", showEdgeLabel);
        jsonObject.put("showImage", showImage);
        jsonObject.put("nodeImageExpr", nodeImageExpr);
        jsonObject.put("initialScale", initialScale);
        jsonObject.put("initialNodelds", initialNodelds);
        jsonObject.put("initalDepth", initialDepth);
        UserGallery userGallery = userGalleryService.findByTaskid(TaskId.getTaskId());
        return CommonResult.success(userGallery.getApp3());
    }

    /**
     * 获取当前用户所有的图库数据
     *
     * @return 返回结果集
     */
    @GetMapping("getGallery")
    public String getGallery() {
        return userGalleryService.findAll();
    }

    /**
     * 根据taskID 返回数据结果
     */
    @GetMapping("getResultByTaskId")
    public String getResultByTaskId(@RequestParam("taskId") String taskId) {
        return userGalleryService.getResultByTaskId(taskId);
    }


    /**
     * 返回文件的 节点等信息
     */

    @GetMapping("getInfo")
    public String getInfo(@RequestParam(value = "taskId") String taskId) {
        TaskInfo taskInfo = taskInfoService.getTaskInfo(taskId);
        Tasks tasks = taskService.findTask(taskId);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("info", taskInfo.getInfo());
        jsonObject.put("create_time", taskInfo.getCreate_time());
        jsonObject.put("fileName", tasks.getFile_name());
        String result = jsonObject.toString();
        return CommonResult.success(result);
    }
}
