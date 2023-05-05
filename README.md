# TermProject2: Plotter, Salter, Smoother

TermProject2 includes two Java-based application for processing and smoothing data in CSV files. The application generates an initial dataset, adds random noise (salt) to the data, and then smooths the data using a user-defined window size. 
One such application  includes support for the Apache Commons Math library and the JFreeChart/JFreeCommons external libraries. 
Finally, it includes a MATLAB Plot, Salt, Smooth script. 
This repository contains well-structured source code, images of the results, and documentation.

## Table of Contents

- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [Testing](#testing)

## Features

- Generate an initial dataset in CSV format
- Add random noise (salt) to the dataset
- Smooth the dataset using a user-defined window size
- Support for Java, Java with external libraries, and MATLAB
- Images of the results of the code

## Installation

To install and set up TermProject2 on your local machine, follow these steps:

1. Clone the repository:

```
git clone https://github.com/shahf215/TermProject2.git
```

2. Navigate to the `TermProject2` directory:

```
cd TermProject2
```

3. Compile the project using your favorite Java development environment, or run the following command in the terminal:

```
javac src/code/*.java
```

## Usage

To run the TermProject2  Java only application, execute the following command in the terminal:

```
java code.pSS.Java.PSSDriver
```

To run the TermProject2  Java External API application, execute the following command in the terminal:

```
java code.pSS.OtherAPI.PSSDriver
```

Interact with the program according to the instructions and prompts displayed in the terminal.

To run the TermProject2  MATLAB application, you will need MATLAB which can be found here: https://matlab.mathworks.com/
Please follow the steps on their website and once you have access and have downloaded MATLAB, you can run the script included here.
