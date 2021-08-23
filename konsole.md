# README

Hi guys, it's me again, Laziem.

This post is a tutorial to use konsole. It is recommended to see this video first : [Paul’s tutorial of Konsole](https://drive.google.com/file/d/1q319GryDD-ZrmxON7GKNZfKuy8dQCktw/view?usp=sharing)

Contents:

* [Tutorial to make konsole job](konsole.md#tutorial-to-make-konsole-job)
* [Konsole current limitation](konsole.md#konsole-current-limitation)
* [Common practises](konsole.md#common-practises)
* [Common problems](konsole.md#common-problems)
* [Some other useful scripts and tips](konsole.md#some-other-useful-scripts-and-tips)

## Tutorial to make konsole job

* First, we need to create a konsole environment for configuration purpose. \(Note : Not recommended to train a model using environment\).

![create\_env](https://user-images.githubusercontent.com/33310853/107001082-fc0e2080-67c3-11eb-9fdf-05127abcf28b.png)

* Click the "Link" Button at the most right on our environment created. This will open a new tab to our jupyter lab environment.

![env\_created](https://user-images.githubusercontent.com/33310853/107001116-0a5c3c80-67c4-11eb-81e6-f30ef54753d2.png)

* In the jupyterlab environment. Lets make a simple python job and save it as job.py:

  \`\`\`python

  import sys

  N = int\(sys.argv\[1\]\)

  computed = {0: 0, 1: 1}

print\(f'Hello guys, its me Konsole !, lets generate sequence of fibonacci number N={N}'\)

def fib\(n\): if n not in computed: computed\[n\] = fib\(n-1\) + fib\(n-2\) return computed\[n\]

print\(\[fib\(x\) for x in range\(N\)\]\)

```text
- Then, create a simple bash script as job.sh. Make sure to set our working directory correctly
```bash
#!/bin/bash
N=$1
cd /data/home
python job.py ${N}
```

* Locate your absolute path of job.sh by running "`realpath job.sh`" and copy the output.

![job](https://user-images.githubusercontent.com/33310853/107001193-34adfa00-67c4-11eb-930d-771ef976c75e.png)

* Open your konsole again to start running our job script and scroll down to Jobs section and start creating a job.

![create\_job](https://user-images.githubusercontent.com/33310853/107001219-3bd50800-67c4-11eb-9a73-6d05c04d8f05.png)

* After clicking  the new job, find the job created at the Jobs section to see the output

![output](https://user-images.githubusercontent.com/33310853/107001240-42637f80-67c4-11eb-8af0-c99ae4cd09ab.png)

Done !

## Konsole current limitation

Note: This Limitation as of 5 Feb 21

* We only have two gpus : \(Tesla V100-PCIE-32GB, Tesla T4\)
* Konsole does not load ~/.bashrc automatically. Need to reload the shell by running  `exec bash` or `exec "$SHELL"`

## Common practises

* Not recommended to use gpu in konsole environment
  * Since we only have two GPUs , we need to use Job Queue to use GPU
  * Adding GPU to konsole environment means it will reserve the GPU only to that environment until the environment terminated. So, others cannot access that particular GPU.
  * Use konsole environment for configuration
* Use a reasonable amount of resources when creating konsole environment. For RAM, it is recommended to stick around 4GB - 8GB. For GPU, only use one GPU for one job since we have only two. For CPU, 2-4 CPUs are sufficient. Despite all of these recommendations, you can always use more resources except GPU, but be sure to use it, do not waste it.
* Make a custom installation bash script for your own. Run it everytime your create a new konsole environment. For example:

  ```bash
  #!/bin/bash

  sudo apt install python3-venv python3.7 python3.8 nano net-tools
  ```

* Using a bash script to create a konsole job
* Regularly check `~/.local/share/Trash/`. Empty your trash bin to reduce shared memory
* Download/Upload our dataset to `/data/shared/Datasets`. So that other people can reuse the dataset. This is a shared folder, everyone can access.
* Print log to external file like `log.txt`, so that we can monitor our log without opening konsole in browser. There are many ways to do this, for python we can use logging library.

## Common problems

* **Problem**: Job status `PodScheduled: Unschedulable` in the Job Queue. **Solution**: Check node at the Nodes section to see available resources. This might be because we requested too many resources.
* **Problem** : Out of Memory. **Solution**: For now we have 2TB shared memory, regularly check `df -h` to check available shared memory and check `du -sh` to check used memory.

## Some other useful scripts and tips

* Use rsync to seamlessly sync our local files to remote or vice versa. However, both ends need to install rsync. Some example command:

  ```bash
  // Remote-to-Local
  rsync -arvz -e 'ssh -p 32610' --progress --exclude 'env' laziem@202.165.22.142:/data/home/checkpoints/logs/ /home/muhdlaziem/Workspace/

  //Local-to-Remote
  rsync -arvz -e 'ssh -p 32610' --progress --exclude 'env' /home/muhdlaziem/Workspace/Dataset/fat-thin laziem@202.165.22.142:/data/shared/Datasets
  ```

* Download large file from google drive

  ```bash
  #!/bin/bash

  fileid=$1
  filename=$2
  curl -c ./cookie -s -L "https://drive.google.com/uc?export=download&id=${fileid}" > /dev/null
  curl -Lb ./cookie "https://drive.google.com/uc?export=download&confirm=`awk '/download/ {print $NF}' ./cookie`&id=${fileid}" -o ${filename}

  #source = https://gist.github.com/tanaikech/f0f2d122e05bf5f971611258c22c110f
  ```

> This post is based on my experiences.

