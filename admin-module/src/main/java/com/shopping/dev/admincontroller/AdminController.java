package com.shopping.dev.admincontroller;

import com.drew.imaging.jpeg.JpegProcessingException;
import com.shopping.dev.admincontroller.addparams.addTotalParams;
import com.shopping.dev.adminservice.AdminService;
import com.shopping.dev.entity.*;
import com.shopping.dev.resultwrapper.MyResultWrapper;
import com.shopping.dev.resultwrapper.UploadFileResultWrapper;
import com.shopping.dev.utils.CheckJson;
import com.shopping.dev.utils.FileUpload;
import com.shopping.dev.utils.PictureEdit;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

@RestController
public class AdminController {

    @Resource
    private AdminService adminService;

    @PostMapping("pic/upload")
    public UploadFileResultWrapper picture(MultipartFile uploadFile) throws IOException {
        byte[] edit = PictureEdit.edit(uploadFile);
        if (edit != null) {
            String url = FileUpload.fileUpload(edit);
            return url != null ? UploadFileResultWrapper.success(url) : UploadFileResultWrapper.error();
        } else {
            return UploadFileResultWrapper.error();
        }
    }

    //------------------------------查询商品-----------------------------------
    // 查询商品,查询tb_item
    @GetMapping("/item/list")
    public addTotalParams<Item> findAllItem(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "20") int rows) {
        return adminService.findAllItem(page, rows);
    }

    // 选择类目,查询tb_item_cat
    @PostMapping("/item/cat/list")
    public List<ItemCartForEasyUiTree> findAllItemCat(@RequestParam(defaultValue = "0") int id) {
        return adminService.findAllItemCat(id);
    }

    // 删除
    @PostMapping("/rest/item/delete")
    public MyResultWrapper deleteItemById(@RequestParam List<Long> ids) {
        int result = this.adminService.changeStatusByIds(0, ids);
        return result > 0 ? MyResultWrapper.success() : MyResultWrapper.error();
    }
    // 上架
    @PostMapping("/rest/item/reshelf")
    public MyResultWrapper reshelfItemById(@RequestParam List<Long> ids) {
        int result = this.adminService.changeStatusByIds(1, ids);
        return result > 0 ? MyResultWrapper.success() : MyResultWrapper.error();
    }
    // 下架
    @PostMapping("/rest/item/instock")
    public MyResultWrapper instockItemById(@RequestParam List<Long> ids) {
        int result = this.adminService.changeStatusByIds(2, ids);
        return result > 0 ? MyResultWrapper.success() : MyResultWrapper.error();
    }

    // 新增商品
    @PostMapping("/item/save")
    public MyResultWrapper addItemAndItemDesc(Item item,
                                              @RequestParam(name = "desc") String desc) {
        System.out.println("====================================================");
        int result = this.adminService.addItemAndItemDesc(item, desc);
        return result > 0 ? MyResultWrapper.success() : MyResultWrapper.error();
    }

    // 编辑商品
    // 根据商品id查询内容
    @GetMapping("/rest/item/query/item/desc/{id}")
    public MyResultWrapper findItemDescByItemId(@PathVariable long id) {
        ItemDesc itemDesc = this.adminService.findItemDescByItemId(id);
        return itemDesc != null ? MyResultWrapper.success(itemDesc) : MyResultWrapper.error();
    }
    // 根据商品id查询规格
    @GetMapping("/rest/item/param/item/query/{id}")
    public MyResultWrapper findItemParamByItemId(@PathVariable long id) {
        ItemParamItem itemParam = this.adminService.findItemParamByItemId(id);
        return itemParam != null ? MyResultWrapper.success(itemParam) : MyResultWrapper.error();
    }
    // 更新商品
    @PostMapping("/rest/item/update")
    public MyResultWrapper updateItemAndParamAndDescById(Item item,
                                                         @RequestParam(name = "desc")String desc,
                                                         @RequestParam(name = "itemParams")String itemParams,
                                                         @RequestParam(name = "itemParamId")long itemParamId) {
        if (!CheckJson.checkJsonByGson(itemParams)) return MyResultWrapper.error();
        boolean result = adminService.updateItemAndParamAndDescById(item, desc, itemParams, itemParamId);
        return result ? MyResultWrapper.success() : MyResultWrapper.error();
    }

    //-----------------------------规格参数-----------------------------------------
    // 规格参数,多表查询
    @GetMapping("/item/param/list")
    public addTotalParams<ItemParamAddItemCatName> findAllItemParam(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int rows) {
        return adminService.findAllItemParam(page, rows);
    }

    // 新增
    // 查看该id是否已在表中
    @GetMapping("item/param/query/itemcatid/{id}")
    public MyResultWrapper findItemParamById(@PathVariable long id) {
        if (adminService.findItemParamById(id)) return MyResultWrapper.success("exits");
        else return MyResultWrapper.error();
    }

    // 插入数据
    @PostMapping("item/param/save/{id}")
    public MyResultWrapper addItemParam(
            @PathVariable(name = "id") long item_cat_id,
            @RequestParam String paramData) {
        if (CheckJson.checkJsonByGson(paramData)){
            if (adminService.addItemParam(item_cat_id, paramData)) {
                return MyResultWrapper.success();
            } else {
                return MyResultWrapper.error();
            }
        } else {
            return MyResultWrapper.error();
        }
    }

    // 删除
    @PostMapping("item/param/delete")
    public MyResultWrapper deleteItemParamByIds(@RequestParam List<Long> ids) {
        if (adminService.deleteItemParamByIds(ids)) return MyResultWrapper.success();
        else return MyResultWrapper.error();
    }


    //-------------------------内容分类管理------------------------------------
    // 查询tb_content_category,返回表中全部内容集合
    @GetMapping("/content/category/list")
    public List<ContentCategoryForEasyUiTree> findAllContentCategory() {
        return adminService.findAllContentCategory();
    }

    // 新增
    @PostMapping("/content/category/create")
    public MyResultWrapper createOneOfCategory(long parentId, String name) {
        boolean result = adminService.createOneOfCategory(parentId, name);
        if (result) return MyResultWrapper.success();
        else return MyResultWrapper.error();
    }

    // 更改
    @PostMapping("content/category/update")
    public MyResultWrapper updateNameByCategoryId(String name, long id) {
        boolean result = adminService.updateNameByCategoryId(name, id);
        if (result) return MyResultWrapper.success();
        else return MyResultWrapper.error();
    }

    //删除
    @PostMapping("content/category/delete")
    public MyResultWrapper deleteOneByCategoryId(long id) {
        if (adminService.deleteOneByCategoryId(id)) return MyResultWrapper.success();
        else return MyResultWrapper.error();
    }


    //-------------------------------内容管理------------------------------------
    // 内容管理,查询tb_content
    @GetMapping("content/query/list")
    public addTotalParams<Content> findAllContent(
            @RequestParam(defaultValue = "0") int categoryId,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int rows) {
        return adminService.findAllContent(categoryId, page, rows);
    }

    // 删除
    @PostMapping("content/delete")
    public MyResultWrapper deleteContentByIds(@RequestParam List<Long> ids) {
        if (adminService.deleteContentByIds(ids)) return MyResultWrapper.success();
        else return MyResultWrapper.error();
    }

    // 修改||新增
    @PostMapping("rest/content/edit")
    public MyResultWrapper updateContentById ( Content content) {
        boolean result = this.adminService.updateOrCreateContentById(content);
        if (result) return MyResultWrapper.success();
        else return MyResultWrapper.error();
    }
}
