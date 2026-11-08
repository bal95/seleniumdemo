package com.example;

import java.nio.file.Paths;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;

public class Example {
  public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
        .setHeadless(false)
      );
      BrowserContext context = browser.newContext();
      context.tracing().start(
        new Tracing.StartOptions()
          .setScreenshots(true)
          .setSnapshots(false)
          .setSources(true)
      );
      Page page = context.newPage();
      page.navigate("https://playwright.dev/");
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Node.js")).click();
      page.getByRole(AriaRole.NAVIGATION, new Page.GetByRoleOptions().setName("Main")).getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Java")).click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Docs")).click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Accessibility testing")).click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Using a test fixture for common axe configuration").setExact(true)).click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Using a fixture").setExact(true)).click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Next Actions »")).click();
      context.tracing().stop(
        new Tracing.StopOptions()
          .setPath(Paths.get("trace.zip"))
      );
    }
  }
}