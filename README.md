[![Run diKTat code style analysis](https://github.com/akuleshov7/git-stat/workflows/Run%20diKTat%20code%20style%20analysis/badge.svg)](https://github.com/cqfn/diktat)
[![License](https://img.shields.io/github/license/akuleshov7/git-stat)](https://github.com/git-stat/blob/master/LICENSE)
[![Hits-of-Code](https://hitsofcode.com/github/akuleshov7/git-stat?branch=main)](https://hitsofcode.com/view/github/akuleshov7/git-stat?branch=main)


GitHub - is an outstanding platform that provides all kinds of insights about the project.
But sometimes you need to get extra statistics that cannot be found on github directly.
[GitHub API](https://developer.github.com/v3/) provides all needed information to get and calculate all needed statistics.
This command-line application will do exactly this thing.

## Run as CLI-application
- Download and extract `git-stat-0.1.0.zip/git-stat-0.1.0.tar`
- **Windows**: run `git-stat.bat` from `bin/` directory; 
  **Linux**: execute `git-stat` from `bin/` directory

`git-stat` is a command line application powered by java. You will need to install java to run it.
FixMe: One day when `kotlin` will be mature enough and git-stat will automatically become a native application.

To run .jar file directly do (see the list of options here: [cli-arguments](#arguments)):
`$ git-stat --options`

## Build executable application 
- Build zip: `$ gradlew distZip`
- Build tar: `$ gradlew distTar`

## Example of usage for calculating unique stargazers 
`git-stat -t stargazers -r "akuleshov7/diktat-demo, cqfn/diktat, yegor256/tacit" -e`

1) `-t stargazers -r cqfn/veniq,cqfn/aibolit -e`
2) `-t stargazers -o artipie -e`
3) `-t stargazers -r cqfn/diktat,akuleshov7/huawei-yapf -e`
4) `-t stargazers -r cqfn/degitx,cqfn/degitx-simulator,cqfn/degit`

This will output the following with `--extended` option ([cli-arguments](#arguments)):
```bash
[INFO] getting statistics for the following repositories: akuleshov7/diktat-demo, cqfn/diktat, yegor256/tacit
[INFO] Number of stargazers: 1362
[INFO] Number of duplicated stars: 4
[INFO] Unique stargazers: akuleshov7, kentr0w, petertrr, yegor256
[INFO] Duplicated stars: User:akuleshov7 Stars:2; User:kentr0w Stars:2; User:petertrr Stars:2; User:yegor256 Stars:2
```

In this set of repositories 4 stars are duplications and 1362 unique stargazers

## <a name="arguments"></a> Cli-arguments
`--debug/-d` - Debug mode to see additional information about the program execution \
`--help/-h` - Obviously - it will print `help` information \
`--configPath/-c` - Full path to a configuration file (FixMe: this will be added later) \
`--extended/-e` - Extended report with more statistic for your type of report. For STARGAZERS it will not only print numbers, but also will list names of stargazers. \
`--type/-t` - Type of statistics. Available types:
- STARGAZERS - to get unique/duplicated stargazers for repositories
- FORKS - to get information about forks
- WATCHERS - to get information about watchers of provided repositories

`--repos/-r` - List of repositories that should be scanned. Example: `"cqfn/diKTat, yegor256/tacit"` \
`--organizations/-o` - List of organizations that should be scanned
 
## Errors and resolution
Please note that it is possible to run `git-stat` application in `--debug` mode. Some of problems can be understood by debug information.
But below are most frequent issues: 
- `403 rate limit exceeded`: github has strict limitations on the number of requests to it's API. We are able to run **only 60 requests**!
- `ClientRequestException`: there is some kind of misprint in the name of the repository or the URL is broken
- `TimeoutCancellationException`: current timeout is 10000 ms on each request
- `SocketException`: usually the problem appears with the proxy enabled
- `UnknownHostException`: looks like you are out of Internet or you connection is not stable

## How to contribute?

Before you make a pull request, make sure the build is clean as we have lot of tests and other prechecks:

```bash
$ gradlew.bat clean build
```

Also see our [Contributing Policy](CONTRIBUTING.md) and [Code of Conduct](CODE_OF_CONDUCT.md)
