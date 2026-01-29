# 方法 1：保留历史（推荐）
# 1) 进入仓库根目录（包含 .git 的目录）
cd "E:\spring microservice template V2\spring-microservice-template"

# 2) 添加新的远程（不覆盖现有 origin）
git remote add tempTest git@github.com:wudye/tempTest.git

# 3) 从子目录生成一个独立分支（路径必须与仓库中一致）
git subtree split -P "update to v2/template_v2" -b template_v2-only

# 4) 把该分支推送到新远程的 main
git push tempTest template_v2-only:main

# 方法 2：不保留历史（在子目录单独初始化一个新仓库）
# 1) 进入子目录
cd "E:\spring microservice template V2\spring-microservice-template\update to v2\template_v2"

# 2) 删除继承自上层仓库的 .git（PowerShell: Remove-Item -Recurse -Force .git）
rm -rf .git

# 3) 初始化新仓库并推送
git init
git add .
git commit -m "Initial commit: template_v2"
git remote add origin git@github.com:wudye/tempTest.git
git branch -M main
git push -u origin main


# 进入仓库根目录
cd E:\spring microservice template V2\spring-microservice-template

# 查看远程
git remote -v

# 确保 origin 指向原始仓库（如需修正）
git remote set-url origin git@github.com:wudye/spring-microservice-template.git

# 抓取 origin 的更新
git fetch origin

# 切换到 main 分支（如果不在 main）
git checkout main

# 将本地 main 与 origin/main 对齐（先拉取远程变更）
git pull origin main

# 将本地 main 设置为跟踪 origin/main（若尚未设置）
git branch --set-upstream-to=origin/main main

# 可选：如果不再需要临时远程，移除 tempTest
git remote remove tempTest

# 验证当前分支和上游
git status
git remote -v
git branch -vv
