#!/usr/bin/python

# super quick command line builds and source dir nav
# hack hack hackity hack
import sys
import os
import subprocess
import shutil
import shlex

EDITOR = os.environ.get('EDITOR','vim')

def run_command(command):
    p = subprocess.Popen(shlex.split(command),
                         cwd=os.getcwd(),
                         env={"PATH": os.getenv("PATH")},
                         stdout=subprocess.PIPE,
                         stderr=subprocess.STDOUT)
    return iter(p.stdout.readline, b'')


def get_main_class(f):
    package = ""
    class_ = ""
    for line in f:
        if "package " in line:
            package = line.replace("package ", "").replace(";", "").strip()
            package = package + "."
        if "class " in line:
            c = line
            class_ = c[c.index("class ")+6:].replace("{","").replace(" ","")
    return package + class_


def build_manifest(main_class, class_path_string, resources_dir, manifest_filename):
    if len(resources_dir) > 0 and "\n" not in resources_dir:
        resources_dir = resources_dir + "\n"
    f = open(manifest_filename, "w")
    f.write("Manifest-Version: 1.0\n")
    f.write("Main-Class: " + main_class + "\n")
    f.write("Class-Path: " + resources_dir + class_path_string + "\n")
    f.close()


def find_main():
    cl = "find . -name '*.java' -exec grep -l \"void main\" \"{}\" +"
    result = run_command(cl).next().strip()
    return result


def main(argv):
    if argv[1] == "main":
        result = find_main()
        print os.path.dirname(result)
        sys.exit(0)

    if argv[1] == "main-file":
        result = find_main()
        print result
        sys.exit(0)

    if argv[1] == "vim":
        result = find_main()
        subprocess.call([EDITOR, result])
        sys.exit(0)

    # find all the jar files
    directory = argv[1]
    out_dir = "out/tmp"
    if not os.path.exists("out"):
        os.mkdir("out")
    if os.path.exists(out_dir):
        shutil.rmtree(out_dir)
    os.mkdir(out_dir)

    jar_files = []
    source_files = []
    resource_files = []
    for root, dirs, files in os.walk(directory):
        for file in files:
            if not out_dir in file and file.endswith(".jar"):
                f = os.path.join(root, file)
                jar_files.append(f)
            if not out_dir in file and file.endswith(".java"):
                f = os.path.join(root, file)
                source_files.append(f)
            if not out_dir in file and "resources/" in os.path.join(root, file):
                f = os.path.join(root, file)
                resource_files.append(f)
                print "found resource: " + f

    for jar in jar_files:
        print "including: " + jar

    class_path = ":".join(jar_files)
    cl = "javac -cp %s -d %s %s" % (class_path, out_dir, " ".join(source_files))
    print cl
    process = subprocess.Popen(shlex.split(cl), cwd=os.getcwd(), env={'PATH': os.getenv("PATH")})
    process.wait()

    # grab the main class
    cl = "find . -name '*.java' -exec grep -l \"void main\" \"{}\" +"
    result = run_command(cl).next().strip()
    print "cracking open " + result
    f = open(result, "r")
    main_class = get_main_class(f).strip()
    print "main class: "+ main_class

    # copy over the deps
    os.mkdir(out_dir + "/deps")
    for f in jar_files:
        shutil.copy2(f, out_dir + "/deps")

    # copy over resources
    os.mkdir(out_dir + "/resources")
    for f in resource_files:
        shutil.copy2(f, out_dir + "/resources")

    class_path_jar = ""
    for root, dirs, files in os.walk(out_dir + "/deps"):
        for f in files:
            class_path_jar += "  deps/" + f.strip() + "\n"

    # build manifest
    build_manifest(main_class, class_path_jar, "resources/", out_dir + "/MANIFEST.MF")

    dirs = [o for o in os.listdir(out_dir) if os.path.isdir(os.path.join(out_dir,o))]
    cls_dir = next(i for i in dirs if not i is "deps")
    local_classes = [f for f in os.listdir(out_dir) if f.endswith(".class")]

    cl = "jar -cvfm %s.jar MANIFEST.MF %s %s" % (main_class, cls_dir, " ".join(local_classes))
    print cl
    process = subprocess.Popen(shlex.split(cl), cwd=out_dir, env={'PATH': os.getenv("PATH")})
    process.wait()

    cl = "java -jar %s.jar" % (main_class)
    print cl
    print ""
    print ""
    process = subprocess.Popen(shlex.split(cl), cwd=out_dir, env={'PATH': os.getenv("PATH")})
    process.wait()


if __name__ == "__main__":
    if len(sys.argv) <= 1:
        print "b.py rootdir run-args  ** b.py . args"
        print "b.py main  ** finds the first directory with main() method"
        print "b.py main-file  ** finds the first file with main() method"
        print "b.py vim  ** opens the first file with main() method in vim"
        sys.exit(1)

    main(sys.argv)
