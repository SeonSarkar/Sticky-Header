
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
      implementation 'com.github.SeonSarkar:Sticky-Header:$latest_version'
      }
  ```
### Alternative:
You may also add the library as an Android Library to your project. All the library files live in ```library```.
## Generic List RV Adapter Usages
#### Constructor arguments for `GenericAdapter`

 *`List<T>`* is a list of object to be passed in a recycler view.
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
 */
  @Override
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
#### create a list of StickyItem

`H` and `C` are Header and Child object respectively.

```java
List<StickyItem<H, C>> items = new ArrayList<>();
items.add(new StickyItem<>(List<C>, H));
items.add(new StickyItem<>(List<C>, H));
```
#### Constructor arguments for `StickyAdapter`

 *`List<StickyItem<H, C>>`* is a list of objects to be passed in sticky recycler view. `H` and `C` are Header and Child object respectively.

 first *`int`* is an id of a header item view layout.

 second *`int`* is an id of a child item view layout.

 *`StickyRecyclerCallBack`* is a callback for views in sticky recycler view.

#### creating a new `StickyAdapter`
```java
mStickyAdapter = new StickyAdapter<>(items, R.layout.row_list_header_item, R.layout.row_list_child_item,
                new StickyRecyclerCallBack<String, MenuItem, RowListHeaderItemBinding, RowListChildItemBinding>() {
                    /**
                     * @param header view binding of a header
                     * @param item object in a header view
                     * @param headerPosition position of a header view
                     */
                    @Override
                    public void bindHeader(RowListHeaderItemBinding header, String item, int headerPosition) {
                        /*setup your views for header in sticky recycler view here*/
                         header.tvHeaderItem.setText(item);

                    }

                    /**
                     * @param child view binding of child item in a sticky recycler view
                     * @param item object in a child view
                     * @param headerPosition position of a header of associated child
                     * @param childPosition position of a child
                     */
                    @Override
                    public void bindChild(RowListChildItemBinding child, MenuItem item, int headerPosition, int childPosition) {
                       /*setup your views for child in sticky recycler view here*/
                        child.tvChildItem.setText(item.getItemName());
                    }
                });
```
#### set the `StickyAdapter`  to your desired `RecyclerView`


 ```java
//for sticky feature ::: Important
myRecyclerView.addItemDecoration(new com.seon.hornet.adapters.itemdecoration.ItemDecoration(mBinding.rvSticky, mStickyAdapter));

myRecyclerView.setAdapter(mStickyAdapter);
```
## Expandable List RV Adapter Usages
#### create a list of ExpandableItem

`G` and `C` are Group and Child object respectively.

```java
List<ExpandableItem<G, C>> items = new ArrayList<>();
items.add(new ExpandableItem<>(List<C>, G));
items.add(new ExpandableItem<>(List<C>, G));
```  
#### Constructor arguments for `ExpandableAdapter`

 *`List<ExpandableItem<G, C>>`* is a list of objects to be passed in sticky recycler view. `G` and `C` are Group and Child object respectively.

 first *`int`* is an id of a header item view layout.

 second *`int`* is an id of a child item view layout.

 *`ExpandableRecyclerCallBack`* is a callback for views in Expandable recycler view.

#### creating a new `ExpandableAdapter`
```java
 mExpandableRecyclerAdapter = new ExpandableAdapter<>(items, R.layout.row_list_header_item, R.layout.row_list_child_item,
                new ExpandableRecyclerCallBack<String, MenuItem, RowListHeaderItemBinding, RowListChildItemBinding>() {
                    /**
                     * @param header view binding of a header
                     * @param item object in a header view
                     * @param groupPosition position of a group
                     */
                    @Override
                    public void bindGroup(RowListHeaderItemBinding header, String item, int groupPosition) {
                     /*setup your views for group in expandable recycler view here*/
                     header.tvHeaderItem.setText(item);
                    }

                    /**
                     * @param child view binding of child item in a sticky recycler view
                     * @param item object in a child view
                     * @param groupPosition position of a group of associated child
                     * @param childPosition position of a child
                     */
                    @Override
                    public void bindChild(RowListChildItemBinding child, MenuItem item, int groupPosition, int childPosition) {
                       /*setup your views for child in expandable recycler view here*/
                       child.tvChildItem.setText(item.getItemName());
                    }

                    @Override
                    public void onExpanded(int groupPosition) {
                        Toast.makeText(ExpandableListActivity.this, "expanded group "+groupPosition, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCollapsed(int groupPosition) {
                        Toast.makeText(ExpandableListActivity.this, "collapsed group "+groupPosition, Toast.LENGTH_SHORT).show();
                    }
                });
```
#### set the `ExpandableAdapter`  to your desired `RecyclerView`
 ```java
myRecyclerView.setAdapter(mExpandableRecyclerAdapter);
```  
## License  
Copyright (c) 2019 Suman Ghimire  
  
Licensed under the Apache License, Version 2.0 (the "License");   
you may not use this file except in compliance with the License.  
You may obtain a copy of the License at  
  
http://www.apache.org/licenses/LICENSE-2.0  
  
Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.