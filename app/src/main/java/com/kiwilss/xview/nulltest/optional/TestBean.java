package com.kiwilss.xview.nulltest.optional;

import java.util.Optional;

/**
 * @author : Lss Administrator
 * @FileName: TestBean
 * @e-mail : kiwilss@163.com
 * @time : 2020/8/4
 * @desc : {DESCRIPTION}
 */
public class TestBean {


    private String test;

    private TestBeanOptional testBeanOptional;

    private Optional<TestBeanOptional> testBeanOptionalOptional;

    public Optional<TestBeanOptional> getTestBeanOptionalOptional() {
        return testBeanOptionalOptional;
    }

    public void setTestBeanOptionalOptional(Optional<TestBeanOptional> testBeanOptionalOptional) {
        this.testBeanOptionalOptional = testBeanOptionalOptional;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public TestBeanOptional getTestBeanOptional() {
        return testBeanOptional;
    }



    public void setTestBeanOptional(TestBeanOptional testBeanOptional) {
        this.testBeanOptional = testBeanOptional;
    }



    public static class TestBeanOptional{
        private String optional;

        public String getOptional() {
            return optional;
        }

        public void setOptional(String optional) {
            this.optional = optional;
        }
    }

}

