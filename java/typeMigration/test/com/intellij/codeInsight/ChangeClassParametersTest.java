package com.intellij.codeInsight;

import com.intellij.codeInsight.template.impl.TemplateManagerImpl;
import com.intellij.refactoring.typeMigration.intentions.ChangeClassParametersIntention;
import com.intellij.testFramework.fixtures.LightCodeInsightFixtureTestCase;

/**
 * User: anna
 */
public class ChangeClassParametersTest extends LightCodeInsightFixtureTestCase {
  public void testNestedTypeElements() {
    String text = "interface Fun<A, B> {}\n" +
                  "class Test {\n" +
                  "  {\n" +
                  "     new Fun<java.util.List<Int<caret>eger>, String> () {};\n" +
                  "  }\n" +
                  "}";

    myFixture.configureByText("a.java", text);
    myFixture.doHighlighting();
    myFixture.launchAction(new ChangeClassParametersIntention());
    assertNull(TemplateManagerImpl.getTemplateState(getEditor()));
  }
}
