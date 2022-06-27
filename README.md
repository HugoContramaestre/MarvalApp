# Marvel App
## Description
This app shows a list of characters and comics from Marvel's public API, by clicking on any of the 
items, a fragment, showing the details of that item opens, allowing the user to see more info about
that item (image, name of the character or title of the comic and a description).
The application is shown using a single Activity, and the navigation through different fragments is 
achieved by using a bottom tab for switching between the flows of the characters' fragments and the 
comics' fragments.

The project has been modularized according to these modules: app, data, domain, usecases and 
testShared.

In the project there are some abstract classes that serve as the base classes for the activities, 
fragments, adapters and viewModels that the project may need. Inside these classes there are 
basic attributes and methods that their children may use or override.

For the possible communication between the fragments and the activity there is a viewModel called
SharedViewModel, which has defined LiveData's and methods that allow the possibility to tell the 
activity from a fragment to show a SnackBar showing an error massage due to a server error or 
show a loader that locks the screen while the screen is loading.

For navigating through the app the Navigation Component was implemented by separating the app in 
two sections that are selectable thanks to a BottomNavigationView tab and shown using a 
FragmentContainerView defined in the MainActivity. Each tab is linked to their corresponding 
nav_graph file in which it's defined the flow for each section, in this case is the 
CharactersFragment/ComicsFragment and CharacterDetailFragment/ComicDetailFragment.

Each Fragment has assigned a viewModel, for this app the functionality of the viewModels are limited
to calling the invoke() method from the respective useCases to obtain the info that the fragment 
requires from the server. In order to make these requests to the server the kotlin coroutines are 
used to received asynchronously the server response, this response comes inside an Either object that
can harbour inside it either the expected object from the response or the failure object that tells 
the type of error that has occurred during the request.

The fragments CharactersFragment and ComicsFragment have defined in their layouts: a recyclerView to
show the list, and empty view to show if there is no content and a retry button that is hidden until
the request for the list's content fails. Each recyclerView implements and adapter that extends 
BaseListAdapter and implements a skeletonView that works as a placeholder that shows the visual 
structure of the adapter's items while the user waits for the server's response. this skeleton can
be implement by hand, defining the skeleton's viewHolder inside the adapter or by calling an 
extension method in SkeletonExtensions, although that method is not being used I decided to leave it
just to show that there is also that possibility. 
The skeleton, the empty screen, the list and the retry button will be shown according to the value 
of the list's state, defined in the sealed class ListState. These possible values are: Loading, 
Error, Empty and Done.

The fragments CharacterDetailFragment and ComicDetailFragment show a big image of the item, the name
of the character or title of the comic and a description of the item if there is one. These 
fragments have a viewModel that works similar to the ones from the previous fragments. In this 
case there is no placeholder to show while the info for the screen is loaded (this request is done 
right after the user enters the detail screen), instead the fragment uses the sharedViewModel to 
tell MainActivity to show a loader that is shown on top of the whole activity's layout.

The service's calls are defined using Retrofit in ApiServices, for the response the object 
NetworkResponse is used to manage the response by receiving the response object in case it's a 
success or the error object if there has been an error in the request. To call to any of the methods 
in ApiServices the methods inside ApiRemoteDataSource are called, here we can define: how the object 
from the service will be mapped from the response object to the domain object, and how the error 
object from the response will be transformed into a Failure object, these objects are the possible 
errors from the server that can happen and the ones that will be used on the front part of the app 
to show the error message through the SnackBar.

The project uses Koin as DI because it's easier and more comfortable to use and implement, the 
dependencies for the DI are defined in the di.kt file.

## Why MVVM
I've chosen MVVM as an architecture for the project due to the fact that is easier and faster to
implement than MVP since i don't have to create different interfaces classes, also because I'm more 
used to use MVVM than MVP, beside with MVVM one have access to different functionalities that Google
provides for this architecture such as creating a custom XML attribute by using Binding adapters 
and linking the content of a view to the value of an attribute in the ViewModel thanks to the 
LiveData's.
As for disadvantages there are the fact that using XML as part of the code can make a bit harder to 
understand the code and to debug. There is also the fact that to use ViewModels the developer has
to implement the library in the project, this may cause some issues in the app depending on the 
version of the library since if a version has a bug then that issue is beyond the developers control, 
which makes you dependent to wait for a new version where the bug is fixed or downgrade the version 
to a more stable one. 

## Features
* Modular architecture based on the CLEAN architecture layer separation.
* MVVM
* Coroutines
* Koin
* Navigation components
* Data binding
* Use of a skeleton library to show the placeholders of the list's items while the user is waiting
for the server's response