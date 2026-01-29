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
