package com.leesin.activitydemo.common.Dialect;

import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;
import org.thymeleaf.standard.processor.StandardXmlNsTagProcessor;
import org.thymeleaf.templatemode.TemplateMode;

import java.util.HashSet;
import java.util.Set;

/**
 * TODO
 *
 * @author wh
 * @date 2020/1/3
 */
public class AuthAuthority extends AbstractProcessorDialect {

    // 定义方言名称
    private static final String NAME = "Auth Authority";
    private static final String prefix = "auth";
    /**
     * 构造函数
     */
    public AuthAuthority() {
        // 设置自定义方言与“方言处理器”优先级相同
        /*
         * TAG_NAME : 表示 设置的方言的名称
         * auth ： 表示在页面使用的标签的名称  是在名称空间中声明的部分
         * */
        super(NAME, prefix, StandardDialect.PROCESSOR_PRECEDENCE);
        System.out.println("设定方言-----");
    }

    @Override
    public Set<IProcessor> getProcessors(final String dialectPrefix) {
        final Set<IProcessor> processors = new HashSet<IProcessor>();

        //添加自定义标签
        System.out.println("添加自定义标签-----");
        processors.add(new AuthorityProcessors(dialectPrefix));
        processors.add(new StandardXmlNsTagProcessor(TemplateMode.HTML, dialectPrefix));
        return processors;
    }
}
