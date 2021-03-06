package crawler;


import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




public class BasicCrawlController {
  private static Logger logger = LoggerFactory.getLogger(BasicCrawlController.class);

  public static void main(String[] args) throws Exception {
   
    String crawlStorageFolder = "./Data";

   
    int numberOfCrawlers = 5;

    CrawlConfig config = new CrawlConfig();

    config.setCrawlStorageFolder(crawlStorageFolder);
    
    
    config.setPolitenessDelay(500);
    config.setUserAgentString("UCI WebCrawler 66008474 62805822");

    
    config.setMaxDepthOfCrawling(50);

   
    config.setMaxPagesToFetch(-1);

   
    config.setIncludeBinaryContentInCrawling(false);

   
    config.setResumableCrawling(false);

    
    PageFetcher pageFetcher = new PageFetcher(config);
    RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
    RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
    CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);

   
    
    controller.addSeed("http://www.ics.uci.edu");
   
    long startTime = System.currentTimeMillis();
    controller.start(BasicCrawler.class, numberOfCrawlers);
    long endTime = System.currentTimeMillis();
    long totalTime = endTime - startTime;
    System.out.print("Time is " + ((totalTime) / 1000d) + " seconds");
    
    System.out.println("words");
   Document.getAggregateData();
   System.out.println("2gram");
   Document.getAggregate2gram();
   System.out.println("subdomain");
   Document.getAggregateSubdomain();
    
   Document.uniqueUrls();
  }
}
