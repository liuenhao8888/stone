<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>uploadPreview演示</title>
    <script src="uploadPreview.js" type="text/javascript"></script>
    <script>
       window.onload = function () { 
            new uploadPreview({ UpBtn: "up_img", DivShow: "imgdiv", ImgShow: "imgShow" });
        }
    </script>
</head>
<body>
    <div id="imgdiv"><img id="imgShow" width="100" height="100" /></div>
    <input type="file" id="up_img" />
</body>
</html>
