### 1. 尽量使用命令行

### 2. 写好每一条Commit Message
![cm](https://raw.githubusercontent.com/839781960/blog/main/IMAGES/2023/git%E6%9C%80%E4%BD%B3%E5%AE%9E%E8%B7%B5/cm.png)

### 3. 用好gitignore
如果仓库中已经有 git rm -f hello.out
然后再gitignore中添加

### 4. 基于分支或者fork的开发模式
开发使用好分支

### 5. 用好release分支和tag

常用tag版本规划
![tag版本](https://raw.githubusercontent.com/839781960/blog/main/IMAGES/2023/git%E6%9C%80%E4%BD%B3%E5%AE%9E%E8%B7%B5/tag%E7%89%88%E6%9C%AC.png)

### 6.修改最后一次commit message
git commit --amend  
git push origin master --force


如果代码已经被别人拉取不能用 上面方法

git reset 也会提交新的历史

解决方法，新建一个跟人的dev分支
git branch dev
git checkout dev  
[Git 使用规范流程](https://www.ruanyifeng.com/blog/2015/08/git-use-process.html)

[常用git命令清单](https://www.ruanyifeng.com/blog/2015/12/git-cheat-sheet.html)

[git工作流程](https://www.ruanyifeng.com/blog/2015/12/git-workflow.html)  

