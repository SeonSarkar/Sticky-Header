
# Sticky, Normal & Expandable List RV Adapter  
  
[![](https://jitpack.io/v/SeonSarkar/Sticky-Header.svg)](https://jitpack.io/#SeonSarkar/Sticky-Header)  
  
Sticky, Normal & Expandable List RV Adapter is an android library created to remove the boilerplate of creating RecyclerView adapters. Mostly to provide the simplest implementation of Adapters .
  
## Contributor  
[Kiran Gyawali](https://www.kirangyawali.com.np)  
  
## Setup  
  
### The easiest way:  
  
#### Step 1
 Add the JitPack repository to your build file.  
        Add it in your root build.gradle at the end of repositories:  
          
```java  
allprojects {  
       repositories {  
           ...  
           maven { url "https://jitpack.io" }  
       }  
   }  
  ```   
 #### Step 2
    Add the dependency  
      
 ```java  
   dependencies {  
      implementation 'com.github.SeonSarkar:Sticky-Header:1.0.1-alpha'  
      }  
  ```  
### Alternative:
You may also add the library as an Android Library to your project. All the library files live in ```library```.
## Generic List RV Adapter Usages  
#### Constructor arguments for `GenericAdapter`
  
 *`List<T>`* is a list of items to be displayed in a recycler view.  
 *`int`* is an id of a list item view layout in a recycler view.  
 *`GenericRecyclerCallBack`* is a callback for views in a recycler view.  
 
#### creating a new `GenericAdapter`
```java
GenericAdapter myAdapter = new GenericAdapter<>(stringList, R.layout.row_list_child_item,  
 new GenericRecyclerCallBack<RowListChildItemBinding, String>() {  
 /**  
 * @param binding viewBinding of a row in a recycler view  
 * @param item object of a row in a recycler view  
 * @param allItem list of all items in a recycler view  
 * @param itemPosition position of an item in a recycler view  
 */  @Override  
  public void bindData(RowListChildItemBinding binding, String item, List<String> allItem, int itemPosition) {  
                /*setup your views for row in recycler view here*/  
			    binding.tvChildItem.setText(item);  
			  }  
        });
 ```
#### set the `GenericAdapter`  to your desired `RecyclerView`
 ```java  
myRecyclerView.setAdapter(myAdapter);
```  
## Sticky List RV Adapter Usages  
 will be added soon.  

## Expandable List RV Adapter Usages  
 will be added soon.  
  
## License  
Copyright (c) 2019 Suman Ghimire  
  
Licensed under the Apache License, Version 2.0 (the "License");   
you may not use this file except in compliance with the License.  
You may obtain a copy of the License at  
  
http://www.apache.org/licenses/LICENSE-2.0  
  
Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.