package com.handmark.pulltorefresh.library;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class PullScrollView extends ScrollView {

	private PullScrollView.OnMyScrollListener onScrollListener;
	private OnScrollToBottomListener onScrollToBottom;

	public PullScrollView(Context paramContext) {
		super(paramContext);
	}

	public PullScrollView(Context paramContext, AttributeSet paramAttributeSet) {
		super(paramContext, paramAttributeSet);
	}

	public PullScrollView(Context paramContext, AttributeSet paramAttributeSet,
			int paramInt) {
		super(paramContext, paramAttributeSet, paramInt);
	}

	public PullScrollView.OnMyScrollListener getOnScrollListener() {
		return this.onScrollListener;
	}
	
  @Override  
    protected void onOverScrolled(int scrollX, int scrollY, boolean clampedX,  
            boolean clampedY) {  
        super.onOverScrolled(scrollX, scrollY, clampedX, clampedY);  
        if(scrollY != 0 && null != onScrollToBottom){  
            onScrollToBottom.onScrollBottomListener(clampedY);  
        }  
    } 
  
  public void setOnScrollToBottomLintener(OnScrollToBottomListener listener){  
      onScrollToBottom = listener;  
  }  

  public interface OnScrollToBottomListener{  
      public void onScrollBottomListener(boolean isBottom);  
  }  
  
	protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3,
			int paramInt4) {
		super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
		if (this.onScrollListener == null)
			return;
		this.onScrollListener.onScroll(paramInt1, paramInt2, paramInt3,
				paramInt4);
	}

	public void setOnMyScrollListener(
			PullScrollView.OnMyScrollListener paramOnMyScrollListener) {
		this.onScrollListener = paramOnMyScrollListener;
	}
	
	public abstract interface OnMyScrollListener
	{
	  public abstract void onScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
	}
}
