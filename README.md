# INSIDER TEST AUTOMATION CASE STUDY UI

It is an automation project created for Insider company. It has 1 case with the following steps
 
* [Insider](https://useinsider.com/)

## Steps

- Visit https://useinsider.com/ and check Insider home page is opened or not
- Select “More” menu in navigation bar, select “Careers” and check Career page, its
Locations, Teams and Life at Insider blocks are opened or not
- Import and save files from GitHub, Dropbox, Google Drive and One Drive
- Click “See All Teams”, select Quality Assurance, click “See all QA jobs”, filter jobs by
Location - Istanbul, Turkey and department - Quality Assurance, check presence of
jobs list
- Check that all jobs’ Position contains “Quality Assurance”, Department contains
“Quality Assurance”, Location contains “Istanbul, Turkey” and “Apply Now” button
- Click “Apply Now” button and check that this action redirects us to Lever Application
form page

## Installation

Use git command

```bash
https://github.com/mehmetcanerisildakli/insider-case-study-ui.git
```

## Usage
Check insider.xml file; inside *src/test/java/tests* and run the file
```
<suite name="testSuite">
    <listeners>
        <listener class-name="common.Listener"/>
    </listeners>
    <tests name="insiderTests">
        <test name="insiderCase">
            <classes>
                <class name="tests.Insider"> </class>
            </classes>
        </test>
    </tests>
</suite>
```

## Technology

* Java
* Selenium
* Maven
* TestNG

## License
[MIT](https://choosealicense.com/licenses/mit/)

